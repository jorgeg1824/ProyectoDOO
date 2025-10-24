package co.edu.uco.nose.data.dao.entity.postgresql.builder;

import java.util.List;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.UserEntity;

public final class UserSqlBuilder {

    public String buildInsert() {
        return """
            INSERT INTO public."Usuario" (
                "id", "tipoIdentificacion", "numeroIdentificacion",
                "primerNombre", "segundoNombre", "primerApellido", "segundoApellido",
                "ciudadResidencia", "correoElectronico", "numeroTelefonoMovil",
                "correoElectronicoConfirmado", "numeroTelefonoMovilConfirmado"
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;
    }

    public String buildUpdate() {
        return """
            UPDATE public."Usuario"
               SET "tipoIdentificacion" = ?, "numeroIdentificacion" = ?,
                   "primerNombre" = ?, "segundoNombre" = ?, "primerApellido" = ?, "segundoApellido" = ?,
                   "ciudadResidencia" = ?, "correoElectronico" = ?, "numeroTelefonoMovil" = ?,
                   "correoElectronicoConfirmado" = ?, "numeroTelefonoMovilConfirmado" = ?
             WHERE "id" = ?
        """;
    }

    public String buildDelete() {
        return "DELETE FROM public.\"Usuario\" WHERE \"id\" = ?";
    }

    private String buildBaseSelect() {
        return """
            SELECT  u."id",
                    ti."id" AS "idTipoIdentificacion", ti."nombre" AS "nombreTipoIdentificacion",
                    u."numeroIdentificacion", u."primerNombre", u."segundoNombre", u."primerApellido", u."segundoApellido",
                    c."id" AS "idCiudadResidencia", c."nombre" AS "nombreCiudadResidencia",
                    d."id" AS "idDepartamentoCiudadResidencia", d."nombre" AS "nombreDepartamentoCiudadResidencia",
                    p."id" AS "idPaisDepartamentoCiudadResidencia", p."nombre" AS "nombrePaisDepartamentoCiudadResidencia",
                    u."correoElectronico", u."numeroTelefonoMovil",
                    u."correoElectronicoConfirmado", u."numeroTelefonoMovilConfirmado"
              FROM public."Usuario" AS u
         LEFT JOIN public."TipoIdentificacion" AS ti ON u."tipoIdentificacion" = ti."id"
         LEFT JOIN public."Ciudad" AS c ON u."ciudadResidencia" = c."id"
         LEFT JOIN public."Departamento" AS d ON c."departamento" = d."id"
         LEFT JOIN public."Pais" AS p ON d."pais" = p."id"
        """;
    }

    public String buildSelectAll() {
        return buildBaseSelect();
    }

    public String buildSelectById() {
        return buildBaseSelect() + " WHERE u.\"id\" = ?";
    }

    public String buildSelectByFilter(final UserEntity filter, final List<Object> params) {
        var sql = new StringBuilder(buildBaseSelect());
        sql.append(" WHERE 1 = 1 ");

        if (ObjectHelper.isNull(filter)) return sql.toString();

        if (!UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getId())) {
            sql.append(" AND u.\"id\" = ? ");
            params.add(filter.getId());
        }
        if (filter.getIdentificationType() != null && !UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getIdentificationType().getId())) {
            sql.append(" AND u.\"tipoIdentificacion\" = ? ");
            params.add(filter.getIdentificationType().getId());
        }
        if (!TextHelper.isEmpty(filter.getIdentificationNumber())) {
            sql.append(" AND u.\"numeroIdentificacion\" = ? ");
            params.add(filter.getIdentificationNumber());
        }
        if (!TextHelper.isEmpty(filter.getFirstName())) {
            sql.append(" AND LOWER(u.\"primerNombre\") LIKE LOWER(?) ");
            params.add("%" + filter.getFirstName() + "%");
        }
        if (!TextHelper.isEmpty(filter.getLastName())) {
            sql.append(" AND LOWER(u.\"primerApellido\") LIKE LOWER(?) ");
            params.add("%" + filter.getLastName() + "%");
        }
        if (filter.getResidenceCity() != null && !UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getResidenceCity().getId())) {
            sql.append(" AND u.\"ciudadResidencia\" = ? ");
            params.add(filter.getResidenceCity().getId());
        }
        if (!TextHelper.isEmpty(filter.getEmail())) {
            sql.append(" AND LOWER(u.\"correoElectronico\") LIKE LOWER(?) ");
            params.add("%" + filter.getEmail() + "%");
        }

        return sql.toString();
    }
}

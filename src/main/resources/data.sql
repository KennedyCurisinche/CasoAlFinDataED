INSERT INTO tipo_cambio(moneda_tipo_cambio) VALUES('SOLES');

INSERT INTO tipo_cambio(moneda_tipo_cambio) VALUES('USD');

INSERT INTO saldo(disponible_local_saldo, disponible_extranjera_saldo) VALUES(500, 10);

INSERT INTO cliente(nombre_cliente, id_saldo) VALUES('KENNEDY GUIA', 1);

INSERT INTO rol(nombrerol) VALUES('ROLE_USER'), ('ROLE_ADMIN');

INSERT INTO usuario(name_usuario, password_usuario, is_active, id_cliente) VALUES('rogger', '$2a$12$TKOTYpehvUuc8AinEGmeV.rV.hnA.fzoEjaxzEguqksrup9zhC1VK', true, 1);

INSERT INTO rol_us(id_usuario, id_rol) VALUES(1, 2);
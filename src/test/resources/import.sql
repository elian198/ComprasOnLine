INSERT INTO empresa ( nombre, razon_social, rubro) VALUES ('Matilde', 'Matilde S.R', 'GASTRONOMICO');
INSERT INTO empresa ( nombre, razon_social, rubro) VALUES ('Havanna', 'Havanna S.R', 'GASTRONOMICO');
INSERT INTO empresa ( nombre, razon_social, rubro) VALUES ('CDA', 'CDA S.R', 'IT');

INSERT INTO producto (activo, descripcion, nombre, precio, empresa_id) VALUES  (1, 'Pasta Frola' ,'Pasta Frola', 1200.00, 3);
INSERT INTO producto (activo, descripcion, nombre, precio, empresa_id) VALUES  (1, 'Lemon Pai' ,'Lemon Pai', 2300.00, 3);
INSERT INTO producto (activo, descripcion, nombre, precio, empresa_id) VALUES  (1, 'App descargas PDF' ,'Descargas PDF', 150000.00, 3);

INSERT INTO rol (tipo_descripcion) VALUES ('BASIC')

INSERT INTO usuario (apellido, email, nombre, password) VALUES ('Quintana', 'alan@gmail.com', 'alan', '1234');
INSERT INTO usuario (apellido, email, nombre, password) VALUES ('Perez', 'jose@gmail.com', 'fabio' ,'1234');
INSERT INTO usuario (apellido, email, nombre, password) VALUES ('Garcia', 'Maria@gmail.com', 'raul', '1234');



INSERT INTO cliente (apellido, codigo_postal, direccion, email, fecha_creacion, nombre, telefono) VALUES ('Chiodi', '1860', 'Mariano Moreno', 'Alan@hotmail.com', '2024-05-27', 'alan', '1156557788'  )
INSERT INTO cliente (apellido, codigo_postal, direccion, email, fecha_creacion, nombre, telefono) VALUES ('Perez', '1860', 'La paz', 'Alan@gmail.com', '2024-05-27', 'alan', '1156557733'  )


INSERT INTO pedido (estado, fecha_creacion, importe_total, cliente_id_cliente) VALUES (1, '2024-05-26',3000.00, 1 );

INSERT INTO orden (cantidad,pedido_id_pedido, producto_id_producto) VALUES (5, 1, 1);

INSERT INTO zona (lugar) VALUES ('Buenos Aires');
INSERT INTO zona (lugar) VALUES ('Entre Rios');
INSERT INTO zona (lugar) VALUES ('Cordoba');
INSERT INTO zona (lugar) VALUES ('Jujuy');
INSERT INTO zona (lugar) VALUES ('Mendoza');
INSERT INTO zona (lugar) VALUES ('Rio Negro');

INSERT INTO socursal (direccion, fecha_alta, telefono, empresa_id, zona_id, provincia) VALUES ('25 de mayo 103', '2024-05-25', '011223444', 1, 1, 'Buenos Aires');
INSERT INTO socursal (direccion, fecha_alta, telefono, empresa_id, zona_id, provincia) VALUES ('Ciudad de Mexico 143', '2024-05-25', '011555566', 1, 2, 'Entre Rios');

INSERT INTO empleado (apellido, fecha_creacion, nombre, socursal_id) VALUES ('Chiodi', '2024-05-27', 'Alan', 1);
INSERT INTO empleado (apellido, fecha_creacion, nombre, socursal_id) VALUES ('Chiodi', '2024-05-27', 'Jose', 2);


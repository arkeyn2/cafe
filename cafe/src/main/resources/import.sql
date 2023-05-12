INSERT INTO rol (rol_nombre) VALUES ('ROLE_ADMIN'), ('ROLE_CHICA'), ('ROLE_MESERO'), ('ROLE_MESERO');

INSERT INTO public.usuario(apellido, email, nombre, nombre_usuario, password, rut) VALUES ('alexis', 'a@a.a','alexis' ,'alexis' , '$2a$10$g1NiG2AiQpTxg/a8HkvB.ObqopcO1QCk76jywtelrv17BMpulR4F2', '123456');
	
INSERT INTO public.usuario(apellido, email, nombre, nombre_usuario, password, rut) VALUES ('secretaria', 's@s.s', 'secretaria', 'secretaria', '$2a$10$uNq0xm359UvjKgS4L0Ad5umETvBYtCNFysqokAkisxOCUGC7XsDri', '1234569');
	
INSERT INTO public.usuario(apellido, email, nombre, nombre_usuario, password, rut) VALUES ('trabajador', 'u@u.u', 'trabajador', 'trabajador','$2a$10$GrxgW1ydycwaoNGdMWrykulnU8w90ay2oS/p4G60mkMx3hbJRlNfC', '98765432');


INSERT INTO public.usuario_rol(	usuario_id, rol_id)	VALUES (1, 1);
INSERT INTO public.usuario_rol(	usuario_id, rol_id)	VALUES (2, 3);
INSERT INTO public.usuario_rol(	usuario_id, rol_id)	VALUES (3, 2);

INSERT INTO public.trago(id, estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ( 1,'valido','20000', 'efectivo', 'trago 20 mil','alcohol','20000');
INSERT INTO public.trago(id, estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ( 2,'valido','30000', 'devito', 'trago 30 mil','alcohol','30000');
INSERT INTO public.trago(id, estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ( 3,'valido','3000', 'credito', 'coca cola','bebida','8000');

INSERT INTO public.horario(	id, estado, horario_entrada, horario_salida) VALUES (1, 'valido', '23:00', '03:00');
INSERT INTO public.horario(	id, estado, horario_entrada, horario_salida) VALUES (2, 'valido', '22:00', '02:00');
INSERT INTO public.horario(	id, estado, horario_entrada, horario_salida) VALUES (3, 'valido', '21:00', '01:00');
INSERT INTO public.horario(	id, estado, horario_entrada, horario_salida) VALUES (1, 'valido', '24:00', '04:00');
INSERT INTO public.horario(	id, estado, horario_entrada, horario_salida) VALUES (1, 'valido', '20:00', '24:00');

INSERT INTO public.control(	id, fecha, hora_entrada, hora_salida, total_horaextra, horarios_id, usuario_id)	VALUES (1, '2016-02-12','20:00', '01:00', '3', 1, 1);

INSERT INTO public.servicios(id, detalle_servicio, estado_servicio, iva, metodo_pago, nombre_servicio, pieza, tipo_servicio, valor)	VALUES (1,'perro', 'activo', 12356, 'efe', 'asd', 's', 'sad', 23654);

INSERT INTO public.acciones(id, adelanto, caja, comisiones, dia_activo, estado, estado_de_pago, fecha_dia, pendiente, tipo_accion, total_ganado, servicio_id, tragos_id, usuario_id) VALUES (1, 1234, 1235, 4556, '2023-05-12', 'pagado', 'p', '2023-05-12', 's', 's', 12345, 1, 1, 1);
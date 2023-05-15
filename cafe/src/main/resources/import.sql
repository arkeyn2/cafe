INSERT INTO rol (rol_nombre) VALUES ('ROLE_ADMIN'), ('ROLE_CHICA'), ('ROLE_MESERO'), ('ROLE_MESERO');

INSERT INTO public.usuario(apellido, email,estado , nombre, nombre_usuario, password, rut) VALUES ('alexis', 'a@a.a','inactivo','alexis' ,'alexis' , '$2a$10$g1NiG2AiQpTxg/a8HkvB.ObqopcO1QCk76jywtelrv17BMpulR4F2', '123456');
	
INSERT INTO public.usuario(apellido, email,estado ,nombre, nombre_usuario, password, rut) VALUES ('secretaria', 's@s.s','inactivo', 'secretaria', 'secretaria', '$2a$10$uNq0xm359UvjKgS4L0Ad5umETvBYtCNFysqokAkisxOCUGC7XsDri', '1234569');
	
INSERT INTO public.usuario(apellido, email,estado , nombre, nombre_usuario, password, rut) VALUES ('trabajador', 'u@u.u','inactivo', 'trabajador', 'trabajador','$2a$10$GrxgW1ydycwaoNGdMWrykulnU8w90ay2oS/p4G60mkMx3hbJRlNfC', '98765432');


INSERT INTO public.usuario_rol(	usuario_id, rol_id)	VALUES (1, 1);
INSERT INTO public.usuario_rol(	usuario_id, rol_id)	VALUES (2, 3);
INSERT INTO public.usuario_rol(	usuario_id, rol_id)	VALUES (3, 2);

INSERT INTO public.trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','0', 'efectivo', '---','alcohol','0');
INSERT INTO public.trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','3800', 'devito', 'trago 20 mil','alcohol','20000');
INSERT INTO public.trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','5700', 'credito', 'trago 30 mil','bebida','30000');
INSERT INTO public.trago(estado_trago, iva, metodo_pago, nombre_trago, tipo_trago, valor_trago)	VALUES ('valido','7600', 'credito', 'trago 40 mil','bebida','40000');

INSERT INTO public.horario(estado, horario_entrada, horario_salida) VALUES (1, 'valido', '23:00', '03:00');
INSERT INTO public.horario(estado, horario_entrada, horario_salida) VALUES (2, 'valido', '22:00', '02:00');
INSERT INTO public.horario(estado, horario_entrada, horario_salida) VALUES (3, 'valido', '21:00', '01:00');
INSERT INTO public.horario(estado, horario_entrada, horario_salida) VALUES (1, 'valido', '24:00', '04:00');
INSERT INTO public.horario(estado, horario_entrada, horario_salida) VALUES (1, 'valido', '20:00', '24:00');

INSERT INTO public.control(fecha, hora_entrada, hora_salida, total_horaextra, horarios_id, usuario_id)	VALUES ('2016-02-12','20:00', '01:00', '3', 1, 1);

INSERT INTO public.servicios(detalle_servicio, estado_servicio, iva, metodo_pago, nombre_servicio, pieza, tipo_servicio, valor)	VALUES ('perro', 'activo', 0, 'efe', '---', 's', 'sad', 0);
INSERT INTO public.servicios(detalle_servicio, estado_servicio, iva, metodo_pago, nombre_servicio, pieza, tipo_servicio, valor)	VALUES ('perro', 'activo', 1000, 'efe', 'asd', 's', 'sad', 1000);


INSERT INTO public.acciones(adelanto, caja, comisiones, dia_activo, estado, estado_de_pago, fecha_dia, pendiente, tipo_accion, total_ganado, servicio_id, tragos_id, usuario_id) VALUES ( 0, 0, 0, '2023-05-15', 'pagado', 'p', '2023-05-15', 's', 's', 0, 1, 2, 1);
INSERT INTO public.acciones(adelanto, caja, comisiones, dia_activo, estado, estado_de_pago, fecha_dia, pendiente, tipo_accion, total_ganado, servicio_id, tragos_id, usuario_id) VALUES ( 0, 0, 0, '2023-05-15', 'pagado', 'p', '2023-05-15', 's', 's', 0, 1, 2, 1);
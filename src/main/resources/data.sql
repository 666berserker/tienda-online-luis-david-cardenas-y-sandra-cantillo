
INSERT INTO Usuario (idUsuario, nombre, correoElectronico, contraseña, direccion, metodoDePago) VALUES
(1, 'Juan Pérez', 'juan.perez@email.com', 'Qwerty123', 'Carrera 45 #10-20', 'Tarjeta de crédito'),
(2, 'Ana Gómez', 'ana.gomez@email.com', 'Pass456', 'Calle 21 #35-50', 'PayPal'),
(3, 'Carlos Ruiz', 'carlos.ruiz@email.com', 'Segura789', 'Avenida Principal #100', 'Transferencia bancaria'),
(4, 'Sofía Martínez', 'sofia.martinez@email.com', 'Clave987', 'Calle 8 #20-30', 'Efectivo'),
(5, 'Diego Fernández', 'diego.fernandez@email.com', 'Contra654', 'Carrera 77 #40-60', 'Tarjeta débito');

INSERT INTO Categoria (idCategoria, nombre) VALUES
(1, 'Tecnología');

INSERT INTO Producto (idProducto, nombre, descripcion, precio, stock, idCategoria) VALUES
(1, 'Laptop', 'Portátil con pantalla Full HD y SSD de 512GB', 89999, 10, 1),
(2, 'Smartphone', 'Teléfono con cámara de 108MP y carga rápida', 49950, 20, 1),
(3, 'Tablet', 'Dispositivo con pantalla táctil de 10 pulgadas', 29999, 15, 1),
(4, 'Auriculares', 'Audífonos inalámbricos con cancelación de ruido', 12999, 25, 1),
(5, 'Teclado', 'Teclado mecánico con iluminación RGB', 8999, 30, 1),
(6, 'Mouse', 'Ratón inalámbrico con sensor óptico de alta precisión', 5999, 50, 1),
(7, 'Monitor', 'Pantalla LED 4K de 27 pulgadas', 49900, 12, 1),
(8, 'Impresora', 'Láser multifuncional con Wi-Fi', 17999, 18, 1),
(9, 'Cámara', 'Cámara digital con lente profesional', 79999, 8, 1),
(10, 'Smartwatch', 'Reloj inteligente con GPS y monitoreo cardíaco', 19999, 22, 1);

INSERT INTO Comentarios (idComentario, idProducto, idUsuario, comentario, fecha) VALUES
(1, 1, 1, 'Excelente rendimiento; muy rápida. ¡Me encanta!', '2025-05-01 10:00:00'),
(2, 2, 2, 'Buena cámara pero la batería dura poco.', '2025-05-03 10:00:00'),
(3, 3, 3, 'No me gustó; pantalla de baja calidad.', '2025-05-05 10:00:00'),
(4, 4, 4, 'Sonido aceptable pero el material parece frágil.', '2025-05-06 10:00:00'),
(5, 5, 5, 'Muy buen teclado mecánico; excelente respuesta.', '2025-05-08 10:00:00');

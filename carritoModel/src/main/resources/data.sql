DROP TABLE carrito IF EXISTS;
DROP TABLE producto IF EXISTS;
DROP TABLE persona IF EXISTS;

CREATE TABLE producto  (
    consecutivo BIGINT IDENTITY NOT NULL PRIMARY KEY,
    nombre VARCHAR(200),
    cantidad_stock number,
    precio number,
    porcentaje_descuento number,
    marca varchar2(100),
    estado varchar2(100)
);

CREATE TABLE persona  (
    consecutivo BIGINT IDENTITY NOT NULL PRIMARY KEY,
    nombre VARCHAR(200),
    documento number,
    tipo_persona varchar(2)
);

CREATE TABLE carrito  (
    consecutivo BIGINT IDENTITY NOT NULL PRIMARY KEY,
    persona_consecutivo number,
    producto_consecutivo number,
    cantidad number,
    CONSTRAINT fk_persona
    FOREIGN KEY (persona_consecutivo)
    REFERENCES persona (consecutivo),
    CONSTRAINT fk_producto
    FOREIGN KEY (producto_consecutivo)
    REFERENCES producto (consecutivo)
    
);

create sequence seq_producto
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
  create sequence seq_persona
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
  
  create sequence seq_carrito
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;

insert into persona values (seq_persona.nextval,'Benjamin Rojas', 104955800, 'C');
insert into persona values (seq_persona.nextval,'Diana Perez', 105044385, 'C');
insert into persona values (seq_persona.nextval,'Julio Iglesias', 24551100, 'C');
insert into persona values (seq_persona.nextval,'Adriana Castellanos', 7685210, 'C');
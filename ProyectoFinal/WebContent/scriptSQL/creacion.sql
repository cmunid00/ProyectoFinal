create database ProyectoFinal;
use ProyectoFinal;
create table Rol(valor varchar(20) primary key);
create table Usuario(codUsuario varchar(30) primary key, nombre varchar(20), password varchar(255), correo varchar(50), rol varchar(20), foreign key (rol) references Rol(valor) on update cascade on delete cascade);
create table Producto(id int identity primary key, codProducto varchar(30), nombre varchar(50), descripcion varchar(255), precio float, url varchar(255));
create table Pedido(codPedido int identity primary key, codUsuario varchar(30), total float, fecha Datetime Default GetDate(), foreign key (codUsuario) references Usuario (codUsuario) on update cascade on delete cascade);
create table Linea_Pedido(id int identity, codPedido int, idProducto int, cantidad int, total float, primary key (id, codPedido), foreign key (codPedido) references Pedido (codPedido) on update cascade on delete cascade, foreign key (idProducto) references Producto (id) on update cascade on delete cascade);
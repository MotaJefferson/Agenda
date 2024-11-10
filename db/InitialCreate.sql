CREATE DATABASE Agenda;

USE Agenda;

CREATE TABLE Contatos (
    ContatoID INT PRIMARY KEY IDENTITY(1,1), 
    Nome NVARCHAR(100) NOT NULL,
    Telefone NVARCHAR(20),
    Email NVARCHAR(100),
    Endereco NVARCHAR(255),
    DataNascimento DATE,
    CriadoEm DATETIME DEFAULT GETDATE(),
    Observacoes NVARCHAR(MAX)
);

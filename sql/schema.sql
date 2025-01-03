CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    nome VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL,
    imagem VARCHAR(255)
);

CREATE TABLE autorizacoes (
    email VARCHAR(255) NOT NULL,
    autorizacao VARCHAR(50) NOT NULL,
    FOREIGN KEY (email) REFERENCES usuarios (email)
);

CREATE TABLE anuncios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    criado_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    anunciante_id INTEGER NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    descricao TEXT,
    imagem VARCHAR(255),
    FOREIGN KEY (anunciante_id) REFERENCES usuarios (id)
);

CREATE TABLE ofertas (
    id SERIAL PRIMARY KEY,
    criado_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ofertante_id INTEGER NOT NULL,
    anunciante_id INTEGER NOT NULL,
    anuncio_id INTEGER NOT NULL,
    FOREIGN KEY (ofertante_id) REFERENCES usuarios (id),
    FOREIGN KEY (anunciante_id) REFERENCES usuarios (id),
    FOREIGN KEY (anuncio_id) REFERENCES anuncios (id)
);

-- INSERT INTO
--     usuarios (id, nome, email, imagem, password, enabled)
-- VALUES
--     (
--         1,
--         'Pedro Santos',
--         'pedro@email.com',
--         '/images/avatars/pedro-avatar.jpg',
--         '{bcrypt}$2a$17$cJlsB3ajUC31ZYJAzMhqfesnKA.ZqD2VP0hqu.t2l.tOv3.GP13dK',
--         true
--     );

-- Insert into usuarios table
 INSERT INTO usuarios (id, nome, email, imagem, password, enabled) VALUES
 (1, 'Pedro Santos', 'pedro@email.com', '/images/avatars/pedro-avatar.jpg', 'pedro', true),
 (2, 'Maria Antonia', 'maria@email.com', '/images/avatars/maria-avatar.jpg', 'maria', true),
 (3, 'João Marcos', 'joao@email.com', '/images/avatars/joao-avatar.jpg', 'joao', true);

 INSERT INTO autorizacoes (email, autorizacao) VALUES ('maria@email.com', 'ROLE_USER');
 
 -- Insert into anuncios table
 INSERT INTO anuncios (id, nome, criado_em, anunciante_id, valor, descricao, imagem) VALUES
 (1, 'Carro', '2024-05-28 15:00', 1, 15750.00, 'Veiculo usado mas bem conservado', '/images/anuncios/anuncio-carro.jpg'),
 (2, 'Moto', '2024-01-29 10:00', 1, 7000.00, 'Aceito troca por outra moto.', '/images/anuncios/anuncio-moto.jpg'),
 (3, 'Livro', '2024-10-20 07:00', 2, 50.00, 'Livro em perfeitas condições,apenas algumas marcas de realçe', '/images/anuncios/anuncio-livro.jpg'),
 (4, 'Tenis', '2024-06-15 20:00', 3, 150.00, 'Tenis com pouco uso', '/images/anuncios/anuncio-tenis.webp'),
 (5, 'Camisa', '2024-03-18 10:00', 3, 47.99, 'Camisa super estilosa', '/images/anuncios/anuncio-camisa.avif');
 
 -- Insert into ofertas table
 INSERT INTO ofertas (id, criado_em, ofertante_id, anunciante_id, anuncio_id) VALUES
 (1, '2024-11-01 10:00', 3, 2, 3),
 (2, '2024-11-03 10:00', 3, 1, 1),
 (3, '2024-11-25 11:00', 2, 1, 2),
 (4, '2024-12-04 12:00', 1, 3, 4);
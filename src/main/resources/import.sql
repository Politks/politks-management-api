-- Inserir políticos
INSERT INTO politician (id, full_name, name, photo) VALUES
(1, 'João da Silva Santos', 'João Silva', 'https://example.com/photos/joao.jpg'),
(2, 'Maria Oliveira Pereira', 'Maria Oliveira', 'https://example.com/photos/maria.jpg');

-- Inserir eleições
INSERT INTO election (id, municipality, position, uf) VALUES
(1, 'SAO_PAULO', 'PREFEITO', 'SP'),
(2, 'SAO_PAULO', 'VEREADOR', 'SP');

-- Inserir candidatos
INSERT INTO candidate (id, politician_id, election_id, votes, number, result) VALUES
(1, 1, 1, 1500000, 12345, 'ELECTED'),
(2, 2, 2, 50000, 54321, 'NOT_ELECTED');
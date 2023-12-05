INSERT INTO role (role_name) VALUES
    ('admin'),
    ('employee');

INSERT INTO user (username, role_id, salt, secured_password) VALUES
    ('Admin123', 1, 'qwertyui', '062742bd7303fd97dc3e059dc3595e97114ae28815901c518b9a4e283e9512f6'),
    ('Employee123', 2, 'asdfghjk', '79fb350ff31e939d2b5d4b8ed498e2ec6782eed7943e943d29e40c6e4fbd077d');

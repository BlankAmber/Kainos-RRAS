INSERT INTO role (role_name) VALUES
    ('admin'),
    ('employee');

INSERT INTO user (email, role_id, secured_password) VALUES
    ('Admin123@email.com', 1, '$argon2id$v=19$m=12,t=20,p=2$zF67un22ocu44k36$7+rzhNKs600R2lucUV1oUH/+Jy787fike14aYJSP4zc'),
    ('Employee123@email.com', 2, '$argon2id$v=19$m=12,t=20,p=2$r73eFJyTJN+IC59x$UYCJdZZkljs5CBP0LKS/gtmYAfiYnmGDLE1iMFOb4e8');

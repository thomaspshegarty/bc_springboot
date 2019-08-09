FROM mysql

ENV MYSQL_DATABASE lcstracker

COPY ./sql-scripts/create_tables.sql /docker-entrypoint-initdb.d/10-init.sql
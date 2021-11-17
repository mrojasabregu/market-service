create table Order(
    id int not null primary key identity,
    order_id int,
    date date,
    state varchar(20),
    id_order_detail int foreign key,
)
CREATE TABLE tutorials_tbl (
                               id INT NOT NULL,
                               order_number VARCHAR(50) NOT NULL,
                               state VARCHAR(50) NOT NULL,
                               document_number VARCHAR(50) NOT NULL,
                               document_type VARCHAR(20) NOT NULL,
                               date DATE
);
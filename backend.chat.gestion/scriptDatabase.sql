create table if not exists tbl_user(
	use_id serial primary key,
	use_username varchar(100) not null,
	use_password varchar(500) not null,
	usu_nickname varchar(100) not null,
	usu_role varchar(20) not null,
	usu_photo text,
	usu_record timestamp default now()
);


create table if not exists tbl_friend(
	fri_id serial primary key,
	use_id int not null,
	fri_record timestamp default now(),
	foreign key(use_id) references tbl_user(use_id)
);


create table if not exists tbl_cluster (
	clu_id serial primary key,
	fri_id int not null,
	use_id_a int not null,
	use_id_b int not null,
	clu_accept boolean default false,
	clu_record timestamp default now(),
	foreign key(fri_id) references tbl_friend(fri_id)
);

create table if not exists tbl_message(
	mes_id serial primary key,
	use_id_a int not null,
	use_id_b int not null,
	mes_message text not null,
	mes_orden int not null,
	mes_date timestamp default now(),
	foreign key(use_id_a) references tbl_user(use_id),
	foreign key(use_id_b) references tbl_user(use_id)
);


SELECT
	*
FROM
    information_schema.triggers
ORDER BY
    tabla,
    nombre_trigger;


CREATE OR REPLACE FUNCTION fn_insert_friend_user()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO tbl_friend(use_id) VALUES (NEW.use_id);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_friend_user
AFTER INSERT ON tbl_user
FOR EACH ROW
EXECUTE FUNCTION fn_insert_friend_user();
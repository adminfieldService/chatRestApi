CREATE TABLE public.tbl_user_roles (
	role_name varchar(255) NOT NULL,
	id int8 NOT NULL,
	user_name varchar(255) NOT NULL,
	CONSTRAINT tbl_user_roles_pkey PRIMARY KEY (role_name, id, user_name)
);
CREATE TABLE public.tbl_users (
	id serial NOT NULL,
	address varchar(255) NULL,
	date_last_login date NULL,
	date_register date NULL,
	device_id_login varchar(255) NULL,
	email varchar(255) NULL,
	gender varchar(255) NULL,
	is_active bool NOT NULL,
	nomor_imei varchar(255) NULL,
	pass_user varchar(255) NOT NULL,
	role_name varchar(255) NOT NULL,
	sesion_id varchar(255) NULL,
	time_last_login varchar(255) NULL,
	user_name varchar(255) NOT NULL,
	user_pass varchar(255) NOT NULL,
	CONSTRAINT tbl_users_pkey PRIMARY KEY (id),
	CONSTRAINT tbl_users_user_name_key UNIQUE (user_name)
);
CREATE TABLE public.tbl_contacts (
	contact_id serial NOT NULL,
	username varchar(300) NULL,
	email varchar(255) NULL,
	realname varchar(255) NULL,
	photo varchar(400) NULL,
	id int8 NULL,
	CONSTRAINT tbl_contacts_pkey PRIMARY KEY (contact_id),
	CONSTRAINT tbl_contacts_fk FOREIGN KEY (id) REFERENCES tbl_users(id) ON UPDATE CASCADE ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED
);
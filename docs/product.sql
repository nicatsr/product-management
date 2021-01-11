create table category
(
    id    bigint generated always as identity (maxvalue 99999)
        constraint category_pkey
            primary key,
    name  text      not null,
    idate timestamp not null,
    udate timestamp not null
);

alter table category
    owner to postgres;

create table photo
(
    id           bigint generated always as identity (maxvalue 99999)
        constraint photo_pkey
            primary key,
    url          text      not null
        constraint photo_url_uk
            unique,
    idate        timestamp not null,
    udate        timestamp not null,
    content_type text
);

alter table photo
    owner to postgres;

create table product
(
    id          bigint generated always as identity (maxvalue 99999)
        constraint product_pkey
            primary key,
    name        text      not null,
    category_id bigint,
    description text,
    photo_id    bigint
        constraint product_photo_fk
            references photo,
    idate       timestamp not null,
    udate       timestamp not null
);

alter table product
    owner to postgres;

create table users
(
    id        bigint generated always as identity (maxvalue 99999)
        constraint users_pkey
            primary key,
    full_name text      not null,
    email     text      not null
        constraint users_email_uk
            unique,
    password  text      not null,
    idate     timestamp not null,
    udate     timestamp not null
);

alter table users
    owner to postgres;

create table role
(
    id           bigint generated always as identity (maxvalue 99999)
        constraint role_pkey
            primary key,
    role_name    text not null,
    success_page text not null
);

alter table role
    owner to postgres;

create table user_role
(
    id      bigint generated always as identity (maxvalue 99999)
        constraint user_role_pkey
            primary key,
    user_id bigint not null,
    role_id bigint not null
);

alter table user_role
    owner to postgres;

INSERT INTO public.category (name, idate, udate) VALUES ('YATAQ DƏSTİ', '2021-01-08 14:05:49.303873', '2021-01-08 14:05:49.303873');
INSERT INTO public.category (name, idate, udate) VALUES ('QONAQ DƏSTİ', '2021-01-08 14:05:58.944394', '2021-01-08 14:05:58.944394');
INSERT INTO public.category (name, idate, udate) VALUES ('YUMŞAQ MEBEL', '2021-01-08 14:06:07.540601', '2021-01-08 14:06:07.540601');
INSERT INTO public.category (name, idate, udate) VALUES ('STUL VƏ MASALAR', '2021-01-08 14:06:15.962673', '2021-01-08 14:06:15.962673');
INSERT INTO public.category (name, idate, udate) VALUES ('DƏHLİZ DƏSTİ', '2021-01-08 14:06:25.157916', '2021-01-08 14:06:25.157916');
INSERT INTO public.category (name, idate, udate) VALUES ('MƏTBƏX DƏSTİ', '2021-01-08 14:06:33.716864', '2021-01-08 14:06:33.716864');
INSERT INTO public.category (name, idate, udate) VALUES ('UŞAQ DƏSTİ', '2021-01-08 14:06:44.593159', '2021-01-08 14:06:44.593159');
INSERT INTO public.category (name, idate, udate) VALUES ('Kateqoriyasız', '2021-01-09 19:30:14.884607', '2021-01-09 19:30:14.884607');


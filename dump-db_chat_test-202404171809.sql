PGDMP     )    	                |            db_chat_test %   14.11 (Ubuntu 14.11-0ubuntu0.22.04.1) %   14.11 (Ubuntu 14.11-0ubuntu0.22.04.1) -    H           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            I           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            J           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            K           1262    16384    db_chat_test    DATABASE     a   CREATE DATABASE db_chat_test WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'es_CO.UTF-8';
    DROP DATABASE db_chat_test;
                postgres    false                        2615    16385    esq_chat    SCHEMA        CREATE SCHEMA esq_chat;
    DROP SCHEMA esq_chat;
                postgres    false            �            1255    16423    fn_insert_friend_user()    FUNCTION     �   CREATE FUNCTION esq_chat.fn_insert_friend_user() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    INSERT INTO tbl_friend(use_id) VALUES (NEW.use_id);
    RETURN NEW;
END;
$$;
 0   DROP FUNCTION esq_chat.fn_insert_friend_user();
       esq_chat          postgres    false    5            �            1259    16410    tbl_cluster    TABLE     �   CREATE TABLE esq_chat.tbl_cluster (
    clu_id bigint NOT NULL,
    fri_id bigint NOT NULL,
    use_id_a bigint NOT NULL,
    use_id_b bigint NOT NULL,
    clu_accept boolean DEFAULT false,
    clu_record timestamp without time zone DEFAULT now()
);
 !   DROP TABLE esq_chat.tbl_cluster;
       esq_chat         heap    postgres    false    5            �            1259    16409    tbl_cluster_clu_id_seq    SEQUENCE     �   CREATE SEQUENCE esq_chat.tbl_cluster_clu_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE esq_chat.tbl_cluster_clu_id_seq;
       esq_chat          postgres    false    214    5            L           0    0    tbl_cluster_clu_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE esq_chat.tbl_cluster_clu_id_seq OWNED BY esq_chat.tbl_cluster.clu_id;
          esq_chat          postgres    false    213            �            1259    16484    tbl_cluster_seq    SEQUENCE     {   CREATE SEQUENCE esq_chat.tbl_cluster_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE esq_chat.tbl_cluster_seq;
       esq_chat          postgres    false    5            �            1259    16397 
   tbl_friend    TABLE     �   CREATE TABLE esq_chat.tbl_friend (
    fri_id bigint NOT NULL,
    use_id bigint NOT NULL,
    fri_record timestamp without time zone DEFAULT now()
);
     DROP TABLE esq_chat.tbl_friend;
       esq_chat         heap    postgres    false    5            �            1259    16396    tbl_friend_fri_id_seq    SEQUENCE     �   CREATE SEQUENCE esq_chat.tbl_friend_fri_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE esq_chat.tbl_friend_fri_id_seq;
       esq_chat          postgres    false    5    212            M           0    0    tbl_friend_fri_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE esq_chat.tbl_friend_fri_id_seq OWNED BY esq_chat.tbl_friend.fri_id;
          esq_chat          postgres    false    211            �            1259    16485    tbl_friend_seq    SEQUENCE     z   CREATE SEQUENCE esq_chat.tbl_friend_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE esq_chat.tbl_friend_seq;
       esq_chat          postgres    false    5            �            1259    24619    tbl_message    TABLE     �   CREATE TABLE esq_chat.tbl_message (
    mes_id integer NOT NULL,
    use_id_a integer NOT NULL,
    use_id_b integer NOT NULL,
    mes_message text NOT NULL,
    mes_orden integer NOT NULL,
    mes_date timestamp without time zone DEFAULT now()
);
 !   DROP TABLE esq_chat.tbl_message;
       esq_chat         heap    postgres    false    5            �            1259    24618    tbl_message_mes_id_seq    SEQUENCE     �   CREATE SEQUENCE esq_chat.tbl_message_mes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE esq_chat.tbl_message_mes_id_seq;
       esq_chat          postgres    false    219    5            N           0    0    tbl_message_mes_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE esq_chat.tbl_message_mes_id_seq OWNED BY esq_chat.tbl_message.mes_id;
          esq_chat          postgres    false    218            �            1259    16387    tbl_user    TABLE     P  CREATE TABLE esq_chat.tbl_user (
    use_id bigint NOT NULL,
    use_username character varying(100) NOT NULL,
    use_password character varying(500) NOT NULL,
    usu_nickname character varying(100) NOT NULL,
    usu_role character varying(20) NOT NULL,
    usu_photo text,
    usu_record timestamp without time zone DEFAULT now()
);
    DROP TABLE esq_chat.tbl_user;
       esq_chat         heap    postgres    false    5            �            1259    16486    tbl_user_seq    SEQUENCE     x   CREATE SEQUENCE esq_chat.tbl_user_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE esq_chat.tbl_user_seq;
       esq_chat          postgres    false    5            �            1259    16386    tbl_user_use_id_seq    SEQUENCE     �   CREATE SEQUENCE esq_chat.tbl_user_use_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE esq_chat.tbl_user_use_id_seq;
       esq_chat          postgres    false    210    5            O           0    0    tbl_user_use_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE esq_chat.tbl_user_use_id_seq OWNED BY esq_chat.tbl_user.use_id;
          esq_chat          postgres    false    209            �           2604    16460    tbl_cluster clu_id    DEFAULT     |   ALTER TABLE ONLY esq_chat.tbl_cluster ALTER COLUMN clu_id SET DEFAULT nextval('esq_chat.tbl_cluster_clu_id_seq'::regclass);
 C   ALTER TABLE esq_chat.tbl_cluster ALTER COLUMN clu_id DROP DEFAULT;
       esq_chat          postgres    false    213    214    214            �           2604    16425    tbl_friend fri_id    DEFAULT     z   ALTER TABLE ONLY esq_chat.tbl_friend ALTER COLUMN fri_id SET DEFAULT nextval('esq_chat.tbl_friend_fri_id_seq'::regclass);
 B   ALTER TABLE esq_chat.tbl_friend ALTER COLUMN fri_id DROP DEFAULT;
       esq_chat          postgres    false    211    212    212            �           2604    24622    tbl_message mes_id    DEFAULT     |   ALTER TABLE ONLY esq_chat.tbl_message ALTER COLUMN mes_id SET DEFAULT nextval('esq_chat.tbl_message_mes_id_seq'::regclass);
 C   ALTER TABLE esq_chat.tbl_message ALTER COLUMN mes_id DROP DEFAULT;
       esq_chat          postgres    false    218    219    219            �           2604    16446    tbl_user use_id    DEFAULT     v   ALTER TABLE ONLY esq_chat.tbl_user ALTER COLUMN use_id SET DEFAULT nextval('esq_chat.tbl_user_use_id_seq'::regclass);
 @   ALTER TABLE esq_chat.tbl_user ALTER COLUMN use_id DROP DEFAULT;
       esq_chat          postgres    false    210    209    210            @          0    16410    tbl_cluster 
   TABLE DATA           c   COPY esq_chat.tbl_cluster (clu_id, fri_id, use_id_a, use_id_b, clu_accept, clu_record) FROM stdin;
    esq_chat          postgres    false    214   95       >          0    16397 
   tbl_friend 
   TABLE DATA           B   COPY esq_chat.tbl_friend (fri_id, use_id, fri_record) FROM stdin;
    esq_chat          postgres    false    212   �5       E          0    24619    tbl_message 
   TABLE DATA           e   COPY esq_chat.tbl_message (mes_id, use_id_a, use_id_b, mes_message, mes_orden, mes_date) FROM stdin;
    esq_chat          postgres    false    219   &6       <          0    16387    tbl_user 
   TABLE DATA           w   COPY esq_chat.tbl_user (use_id, use_username, use_password, usu_nickname, usu_role, usu_photo, usu_record) FROM stdin;
    esq_chat          postgres    false    210   C6       P           0    0    tbl_cluster_clu_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('esq_chat.tbl_cluster_clu_id_seq', 1, false);
          esq_chat          postgres    false    213            Q           0    0    tbl_cluster_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('esq_chat.tbl_cluster_seq', 1, false);
          esq_chat          postgres    false    215            R           0    0    tbl_friend_fri_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('esq_chat.tbl_friend_fri_id_seq', 7, true);
          esq_chat          postgres    false    211            S           0    0    tbl_friend_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('esq_chat.tbl_friend_seq', 1, false);
          esq_chat          postgres    false    216            T           0    0    tbl_message_mes_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('esq_chat.tbl_message_mes_id_seq', 4, true);
          esq_chat          postgres    false    218            U           0    0    tbl_user_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('esq_chat.tbl_user_seq', 51, true);
          esq_chat          postgres    false    217            V           0    0    tbl_user_use_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('esq_chat.tbl_user_use_id_seq', 1, false);
          esq_chat          postgres    false    209            �           2606    16462    tbl_cluster tbl_cluster_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY esq_chat.tbl_cluster
    ADD CONSTRAINT tbl_cluster_pkey PRIMARY KEY (clu_id);
 H   ALTER TABLE ONLY esq_chat.tbl_cluster DROP CONSTRAINT tbl_cluster_pkey;
       esq_chat            postgres    false    214            �           2606    16427    tbl_friend tbl_friend_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY esq_chat.tbl_friend
    ADD CONSTRAINT tbl_friend_pkey PRIMARY KEY (fri_id);
 F   ALTER TABLE ONLY esq_chat.tbl_friend DROP CONSTRAINT tbl_friend_pkey;
       esq_chat            postgres    false    212            �           2606    24627    tbl_message tbl_message_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY esq_chat.tbl_message
    ADD CONSTRAINT tbl_message_pkey PRIMARY KEY (mes_id);
 H   ALTER TABLE ONLY esq_chat.tbl_message DROP CONSTRAINT tbl_message_pkey;
       esq_chat            postgres    false    219            �           2606    16448    tbl_user tbl_user_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY esq_chat.tbl_user
    ADD CONSTRAINT tbl_user_pkey PRIMARY KEY (use_id);
 B   ALTER TABLE ONLY esq_chat.tbl_user DROP CONSTRAINT tbl_user_pkey;
       esq_chat            postgres    false    210            �           2620    16424    tbl_user trg_friend_user    TRIGGER     �   CREATE TRIGGER trg_friend_user AFTER INSERT ON esq_chat.tbl_user FOR EACH ROW EXECUTE FUNCTION esq_chat.fn_insert_friend_user();
 3   DROP TRIGGER trg_friend_user ON esq_chat.tbl_user;
       esq_chat          postgres    false    220    210            �           2606    16475 #   tbl_cluster tbl_cluster_fri_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY esq_chat.tbl_cluster
    ADD CONSTRAINT tbl_cluster_fri_id_fkey FOREIGN KEY (fri_id) REFERENCES esq_chat.tbl_friend(fri_id);
 O   ALTER TABLE ONLY esq_chat.tbl_cluster DROP CONSTRAINT tbl_cluster_fri_id_fkey;
       esq_chat          postgres    false    214    3238    212            �           2606    16449 !   tbl_friend tbl_friend_use_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY esq_chat.tbl_friend
    ADD CONSTRAINT tbl_friend_use_id_fkey FOREIGN KEY (use_id) REFERENCES esq_chat.tbl_user(use_id);
 M   ALTER TABLE ONLY esq_chat.tbl_friend DROP CONSTRAINT tbl_friend_use_id_fkey;
       esq_chat          postgres    false    3236    210    212            �           2606    24628 %   tbl_message tbl_message_use_id_a_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY esq_chat.tbl_message
    ADD CONSTRAINT tbl_message_use_id_a_fkey FOREIGN KEY (use_id_a) REFERENCES esq_chat.tbl_user(use_id);
 Q   ALTER TABLE ONLY esq_chat.tbl_message DROP CONSTRAINT tbl_message_use_id_a_fkey;
       esq_chat          postgres    false    3236    219    210            �           2606    24633 %   tbl_message tbl_message_use_id_b_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY esq_chat.tbl_message
    ADD CONSTRAINT tbl_message_use_id_b_fkey FOREIGN KEY (use_id_b) REFERENCES esq_chat.tbl_user(use_id);
 Q   ALTER TABLE ONLY esq_chat.tbl_message DROP CONSTRAINT tbl_message_use_id_b_fkey;
       esq_chat          postgres    false    219    210    3236            @   g   x��й�0C�X[�X��B�?��)|�'�9^x�r&��3sz�<�V�� �c���"@�U�Ũ	=F]�1 ��Ɗ�I�$�\�|���F5I?      >   f   x�e��1E�5T1�{\K��#��-���52r���zlm��B�N~b�t�GsP�<[M*[���րd$�����b�Eu��L���u��X9,�+���R'      E      x������ � �      <   �  x���Ks�@��5��,��MӀ;��5�梢�oQ~}bRq7�T����w U�6#�3$π{�c��W����#{���e^��=`ݡ��XJ��S���SJ�+�C��v�ҥXR�#`U_Q����8���f2H�y�<��[ݰ�^��5^Jf��j������u�B� i.E0�"��PٕS�k��3폨<��ETG�>#��.bw�\ͦ�z�v~�q7Y�a��4֪ѫ�w���Z��jv��GEF�/l^` ������K�ȡu�T D�D�ư�Е��s�-�,��12�&?�Qq��D�����}3��T�&��e�4�����x��`��z����#7_{���6���O{GRT��'���8L��!mKR&׼u�\�'I�;���q�`�V�h	�����,���jZ���`���w2�Y4�HyL�oֿx�.M7'P�x���EhS֒ ��]��鲏��J_i���+�m��X��O�<C�L�$�?���wx�A     
create table hibernate_sequences (
   sequence_name varchar(255) CHARACTER SET utf8 not null ,
    next_val bigint,
    primary key (sequence_name)
) engine=MyISAM
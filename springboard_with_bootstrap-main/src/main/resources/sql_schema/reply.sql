use sqldb;

create table reply
(
    rno int auto_increment primary key,
    bno int not null,
    replyText varchar(2000) not null,
    replier varchar(100) not null,
    regDate timestamp default current_timestamp() null,
    updateDate timestamp default  current_timestamp() null,
    constraint fk_reply_board foreign key (bno) references board(bno)
);

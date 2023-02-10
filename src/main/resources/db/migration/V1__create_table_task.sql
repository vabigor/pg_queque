create table task
(
    id          bigint not null primary key,
    status      integer not null default 0,     -- 0 - новая, 1 - в работе, 2 - выполнена, 3 - ошибка, 4 - фатальная ошибка (повтора не будет)
    attempt     integer not null default 0,
    delayed_to  timestamp null,
    error_text  text null
);
create index task__status__delayed_to__idx on task (status, delayed_to);

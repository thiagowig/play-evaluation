# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table curso (
  id                        integer not null,
  nome                      varchar(255),
  constraint pk_curso primary key (id))
;

create table disciplina (
  id                        integer not null,
  nome                      varchar(255),
  carga_horaria             integer,
  turma_id                  integer,
  data_inicio               timestamp,
  data_fim                  timestamp,
  curso_id                  integer,
  constraint pk_disciplina primary key (id))
;

create table frequencia (
  id                        integer not null,
  tipo_frequencia_enum      varchar(3),
  valor                     double,
  disciplina_id             integer,
  constraint ck_frequencia_tipo_frequencia_enum check (tipo_frequencia_enum in ('FEV','MAR','ABR','MAI','JUN','JUL','AGO','SET','OUT','NOV','DEZ','MAX')),
  constraint pk_frequencia primary key (id))
;

create table nota (
  id                        integer not null,
  tipo_nota_enum            varchar(28),
  valor                     double,
  disciplina_id             integer,
  constraint ck_nota_tipo_nota_enum check (tipo_nota_enum in ('AVAL_1','AVAL_2','ATIVIDADES_AUTOINSTRUCIONAIS','REVISAO_CONTEUDO','AVAL_3','EX_EXP')),
  constraint pk_nota primary key (id))
;

create table turma (
  id                        integer not null,
  nome                      varchar(255),
  constraint pk_turma primary key (id))
;

create sequence curso_seq;

create sequence disciplina_seq;

create sequence frequencia_seq;

create sequence nota_seq;

create sequence turma_seq;

alter table disciplina add constraint fk_disciplina_turma_1 foreign key (turma_id) references turma (id) on delete restrict on update restrict;
create index ix_disciplina_turma_1 on disciplina (turma_id);
alter table disciplina add constraint fk_disciplina_curso_2 foreign key (curso_id) references curso (id) on delete restrict on update restrict;
create index ix_disciplina_curso_2 on disciplina (curso_id);
alter table frequencia add constraint fk_frequencia_disciplina_3 foreign key (disciplina_id) references disciplina (id) on delete restrict on update restrict;
create index ix_frequencia_disciplina_3 on frequencia (disciplina_id);
alter table nota add constraint fk_nota_disciplina_4 foreign key (disciplina_id) references disciplina (id) on delete restrict on update restrict;
create index ix_nota_disciplina_4 on nota (disciplina_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists curso;

drop table if exists disciplina;

drop table if exists frequencia;

drop table if exists nota;

drop table if exists turma;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists curso_seq;

drop sequence if exists disciplina_seq;

drop sequence if exists frequencia_seq;

drop sequence if exists nota_seq;

drop sequence if exists turma_seq;


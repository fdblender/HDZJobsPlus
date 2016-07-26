drop table HDZ_Application;
drop table HDZ_Education;
drop table HDZ_jobhistory;
drop table HDZ_reftable;
drop table HDZ_jobs;
drop table HDZ_jobtrack;



drop sequence application_id_seq;
drop sequence education_id_seq;
drop sequence jobhistory_id_seq;
drop sequence reftable_id_seq;
drop sequence jobs_id_seq;
drop sequence jobtrack_id_seq;

create sequence  application_id_seq start with 1 increment by 1 nocache;
create sequence  education_id_seq start with 1 increment by 1 nocache;
create sequence  jobhistory_id_seq start with 1 increment by 1 nocache;
create sequence  reftable_id_seq start with 1 increment by 1 nocache;
create sequence  jobs_id_seq start with 1 increment by 1 nocache;
create sequence  jobtrack_id_seq start with 1 increment by 1 nocache;

create table HDZ_Application (
applicationID integer primary key,
email varchar2(50) unique not null,
pwd varchar2(200) not null,
firstname varchar2(100) not null,
lastname varchar2(100) not null,
bday varchar2(100) not null,
citizenflag varchar2(1),
citizen varchar2(100) not null,
visaflag varchar2(1),
visa varchar2(100) not null,
veteranflag varchar2(1),
veteran varchar2(100) not null,
codingtest varchar2(1),
drugtestflag varchar2(1),
drugtest varchar2(100) not null,
stdpanelflag varchar2(1),
stdpanel varchar2(100) not null,
dottestflag varchar2(1),
dottest varchar2(100) not null,
alcoholtestflag varchar2(1),
alcoholtest varchar2(100) not null,
appstatus varchar2(1)
);


insert into HDZ_Application (applicationid, email, pwd, firstname, lastname, bday, citizenflag, citizen, visaflag, visa, veteranflag, veteran, codingtest, drugtestflag, drugtest, stdpanelflag, stdpanel, dottestflag, dottest, alcoholtestflag,alcoholtest, appstatus) 
values (application_id_seq.nextval, 'sal@gmail.com', 'password', 'sal', 'snooze', '08/01/1992', null,'yes', null,'no', null,'yes', null, null,'yes',null,'yes',null,'yes',null,'yes',null);



create table HDZ_Education(
educationid integer primary key,
applicationid integer,
schoolname varchar2(200) not null,
degreecompleted varchar2(100),
datecompleted varchar2(100),
CONSTRAINT fk_HDZ_Education_applicationID FOREIGN KEY (applicationID) references HDZ_Application(applicationID)
);

insert into HDZ_Education (educationid,applicationid, schoolname, degreecompleted, datecompleted ) 
values (education_id_seq.nextval,2, 'GWU', 'MS', '06/05/2016');

create table HDZ_jobhistory(
jobhistoryid integer primary key,
applicationid integer,
position varchar2(50) not null,
companyname varchar2(200) not null,
startdate varchar2(100) not null,
enddate varchar2(100),
description varchar2(100) not null,
CONSTRAINT fk_jobhistory_applicationID FOREIGN KEY (applicationID) references HDZ_application(applicationID)
);

insert into HDZ_jobhistory (jobhistoryid,applicationID, position, companyname, startdate,enddate, description ) 
values (jobhistory_id_seq.nextval, 2,'Software Engineer', 'Facebook', '08/05/2010','01/07/2016','Java Programmer, Agile Development');


create table HDZ_reftable(
refid integer primary key,
applicationid integer,
refname varchar2(50) not null,
refemail varchar2(200) not null,
refphone varchar2(200) not null,
refposition varchar2(200) not null,
CONSTRAINT fk_HDZ_reftable_applicationID FOREIGN KEY (applicationID) references HDZ_application(applicationID)
);

insert into HDZ_reftable (refid, applicationID,refname, refemail, refphone,refposition ) 
values (reftable_id_seq.nextval, 2,'Bob', 'bob@gmail.com', '2029940771','Senior Software Engineer');

create table HDZ_Jobs(
jobsid integer primary key,
position varchar2(50) not null,
description varchar2(200) not null
);

insert into HDZ_Jobs (jobsid, position, description)
values (jobs_id_seq.nextval, 'Software Engineer', 'Entry Level Java Programming and testing');

insert into HDZ_Jobs (jobsid, position, description)
values (jobs_id_seq.nextval, 'Hardware Engineer', 'ASIC CPU Design and Testing');

insert into HDZ_Jobs (jobsid, position, description)
values (jobs_id_seq.nextval, 'Quality Assurance', 'Software testing and configuration');

create table HDZ_Jobtrack(
jobtrackid integer primary key,
applicationid integer,
jobsid integer,
CONSTRAINT fk_HDZ_Jobtrack_applicationID FOREIGN KEY (ApplicationID) references HDZ_application(applicationID),
CONSTRAINT fk_HDZ_Jobtrack_jobsID FOREIGN KEY (jobsID) references HDZ_jobs(jobsID)
);

insert into HDZ_Jobtrack (jobtrackid, applicationID, jobsID)
values (jobtrack_id_seq.nextval, 2, 1);


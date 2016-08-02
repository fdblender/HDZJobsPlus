
drop table HDZ_jobhistory;
drop table HDZ_education;
drop table HDZ_reftable;
drop table HDZ_jobskills;
drop table HDZ_applicantskills;
drop table HDZ_tests;
drop table HDZ_jobquestions;
drop table HDZ_application;
drop table HDZ_jobs;
drop table HDZ_positions;
drop table HDZ_applicant;
drop table HDZ_employee;


drop sequence hdz_employee_id_seq;
drop sequence hdz_application_id_seq;
drop sequence hdz_jobhistory_id_seq;
drop sequence hdz_education_id_seq;
drop sequence hdz_reftable_id_seq;
drop sequence hdz_jobs_id_seq;
drop sequence hdz_applicant_id_seq;
drop sequence hdz_jobskills_id_seq;
drop sequence hdz_applicantskills_id_seq;
drop sequence hdz_jobquestions_id_seq;
drop sequence hdz_tests_id_seq;
drop sequence hdz_positions_id_seq;

create sequence  hdz_applicant_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_education_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_jobhistory_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_reftable_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_jobs_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_application_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_employee_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_jobskills_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_applicantskills_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_jobquestions_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_tests_id_seq  start with 1 increment by 1 nocache;
create sequence  hdz_positions_id_seq start with 1 increment by 1 nocache;


create table HDZ_Applicant (
applicantid integer primary key,
email varchar2(50) unique ,
hashedpwd varchar2(200) ,
salt varchar2(200),
firstname varchar2(100) ,
lastname varchar2(100) ,
bday varchar2(100) ,
citizenflag varchar2(1),
citizen varchar2(100) ,
visaflag varchar2(1),
visa varchar2(100) ,
veteranflag varchar2(1),
veteran varchar2(100) ,
drugtestflag varchar2(1),
stdpanelflag varchar2(1),
dottestflag varchar2(1),
alcoholtestflag varchar2(1),
employeeflag varchar2(1),
invitedflag varchar2(1),
codingflag varchar2(1),
gravatarurl varchar2(200),
resumesummary varchar(200),
resumeobjective varchar(200),
workrefflag varchar2(1)
);


insert into HDZ_Applicant (applicantid, email, hashedpwd, salt, firstname, lastname, bday, citizenflag, citizen, visaflag, visa, veteranflag, veteran, drugtestflag, stdpanelflag, dottestflag, alcoholtestflag, employeeflag, invitedflag, codingflag, gravatarurl, resumesummary, resumeobjective) 
values (hdz_applicant_id_seq.nextval, 'sal@gmail.com', '8f23afaa0ec822bef56b4e71da62d1d19cb569b7957124b57816463fb952fbdf', 'cDxst4bFuL7tqMdGPSy+RgCW+1EJ2F40LsNh+uHwHUs=', 'Sal', 'Snooze', '08/01/1992', null,'yes', null,'no', null,'yes', null, null, null, null, 'N', null, null, 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50', 
'5 years of Java development experience', 'Transition to a challenging position in Java web development');

insert into HDZ_Applicant (applicantid, email, hashedpwd, salt, firstname, lastname, bday, citizenflag, citizen, visaflag, visa, veteranflag, veteran, drugtestflag, stdpanelflag, dottestflag, alcoholtestflag, employeeflag, invitedflag, codingflag, gravatarurl, resumesummary, resumeobjective) 
values (hdz_applicant_id_seq.nextval, 'mick@gmail.com', 'a099f512e3c66e09adff0997f420d6a3e88bb1d341dde58f73810b7f9bafabca', '3jVlR2p96w355LrcZv1sf0K/dh+zKLbkY8JjpJpM8/s=', 'Mick', 'McClain', '08/01/1992', null,'yes', null,'no', null,'yes', null, null, null, null, 'N', null, null, 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50', 
'5 years of Java development experience', 'Transition to a challenging position in Java web development');

insert into HDZ_Applicant (applicantid, email, hashedpwd, salt, firstname, lastname, bday, citizenflag, citizen, visaflag, visa, veteranflag, veteran, drugtestflag, stdpanelflag, dottestflag, alcoholtestflag, employeeflag, invitedflag, codingflag, gravatarurl, resumesummary, resumeobjective)
values (hdz_applicant_id_seq.nextval, 'roy@gmail.com', '447903c4bddf950b8fed39041d3f786a04601be1107de2667cb3369e1ee420ce', '6GxvpU56PKnpNC5OddEAgKhJz252pAkITHKO7Hz2r+s=', 'Roy', 'Cook', '07/05/1988', null,'yes', null,'no', null,'yes', null, null, null, null, 'N', null, null, 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50', 
'2 years of Java development', 'Gain a position in Java development');

insert into HDZ_Applicant (applicantid, email, hashedpwd, salt, firstname, lastname, bday, citizenflag, citizen, visaflag, visa, veteranflag, veteran, drugtestflag, stdpanelflag, dottestflag, alcoholtestflag, employeeflag, invitedflag, codingflag, gravatarurl, resumesummary, resumeobjective)
values (hdz_applicant_id_seq.nextval, 'jerry@gmail.com', '634becb83a351b7201e75d8e69eabe64be3f9d8bb1f4c5cb86da00bdf6cb123d', '7rRh4eqTNh+LJL0Iqp3o3n3ZwU/Ektm7xwsK1TczFQE=', 'Jerry', 'Wu', '03/09/1980', null,'no', null,'yes', null,'yes', null, null, null, null, 'N', null, null, 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50', 
'2 years of experience as a Hardware Engineer', 'Gain a challenging position in hardware');

insert into HDZ_Applicant (applicantid, email, hashedpwd, salt, firstname, lastname, bday, citizenflag, citizen, visaflag, visa, veteranflag, veteran, drugtestflag, stdpanelflag, dottestflag, alcoholtestflag, employeeflag, invitedflag, codingflag, gravatarurl, resumesummary, resumeobjective)
values (hdz_applicant_id_seq.nextval, 'volker@gmail.com', '85c4045386bcb895c66df0661cd9ea573e91626b8c1dd92026fe05a67196360c', 'o6uSUE7IKGUMAQ1mrj+k8Ggf5CHlmfxGAiWoHv8rzok=', 'Volker', 'Sorger', '08/06/1989', null,'yes', null,'no', null,'yes', null, null, null, null, 'N', null, null, 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50', 
'2 years of experience as a Quality Assurance Engineer', 'Gain a position in quality assurance');

insert into HDZ_Applicant (applicantid, email, hashedpwd, salt, firstname, lastname, bday, citizenflag, citizen, visaflag, visa, veteranflag, veteran, drugtestflag, stdpanelflag, dottestflag, alcoholtestflag, employeeflag, invitedflag, codingflag, gravatarurl, resumesummary, resumeobjective)
values (hdz_applicant_id_seq.nextval, 'tommy@gmail.com', '0facf4210ee68bd39bdf1a55f24ea95ab40a387dfe8066a2f394e2434803635c', 'jdPz/JFmmyLhUif/3kcL1h7hR232Buv8GTOiniy0EUI=', 'Robert', 'Tommy', '06/07/1985', null,'no', null,'yes', null,'yes', null, null, null, null, 'N', null, null, 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50', 
'3 years of Java development experience', 'Gain a challenging position in Java web development');

create table HDZ_Education(
educationid integer primary key,
educationflag varchar2(1),
applicantid integer,
schoolname varchar2(200) ,
degreecompleted varchar2(100),
datecompleted varchar2(100),
CONSTRAINT fk_HDZ_Education_applicantID FOREIGN KEY (applicantID) references HDZ_Applicant(applicantID)
);

insert into HDZ_Education (educationid,educationflag, applicantid, schoolname, degreecompleted, datecompleted ) 
values (hdz_education_id_seq.nextval,null,1, 'GWU', 'MS', '06/05/2016');

insert into HDZ_Education (educationid,educationflag, applicantid, schoolname, degreecompleted, datecompleted ) 
values (hdz_education_id_seq.nextval,null,2, 'GMU', 'BE', '06/20/2015');

insert into HDZ_Education (educationid,educationflag, applicantid, schoolname, degreecompleted, datecompleted ) 
values (hdz_education_id_seq.nextval,null,3, 'CSU', 'PHD', '05/15/2010');

insert into HDZ_Education (educationid,educationflag, applicantid, schoolname, degreecompleted, datecompleted ) 
values (hdz_education_id_seq.nextval,null,4, 'ASU', 'MS', '05/05/2014');

insert into HDZ_Education (educationid,educationflag, applicantid, schoolname, degreecompleted, datecompleted ) 
values (hdz_education_id_seq.nextval,null,2, 'UTD', 'PHD', '05/10/2013');

create table HDZ_jobhistory(
jobhistoryid integer primary key,
jobhistoryflag varchar2(1),
applicantid integer,
position varchar2(50) ,
companyname varchar2(200) ,
startdate varchar2(100) ,
enddate varchar2(100),
description varchar2(100) ,
CONSTRAINT fk_jobhistory_applicantID FOREIGN KEY (applicantID) references HDZ_applicant(applicantID)
);

insert into HDZ_jobhistory (jobhistoryid,jobhistoryflag,applicantID, position, companyname, startdate,enddate, description ) 
values (hdz_jobhistory_id_seq.nextval,null, 1,'Software Engineer', 'Facebook', '08/05/2010','01/07/2016','Java Programmer, Agile Development');

insert into HDZ_jobhistory (jobhistoryid,jobhistoryflag,applicantID, position, companyname, startdate,enddate, description ) 
values (hdz_jobhistory_id_seq.nextval,null, 1,'Business Analyst', 'IPS', '05/05/2013','01/07/2015','Agile, Waterfall methodology');

insert into HDZ_jobhistory (jobhistoryid,jobhistoryflag,applicantID, position, companyname, startdate,enddate, description ) 
values (hdz_jobhistory_id_seq.nextval,null, 1,'Hardware Engineer', 'Apple', '01/25/2010','01/20/2016','PCB design, Velilog, TCL,Perl');

insert into HDZ_jobhistory (jobhistoryid,jobhistoryflag,applicantID, position, companyname, startdate,enddate, description ) 
values (hdz_jobhistory_id_seq.nextval,null, 1,'Cyber Security Engineer', 'Amazon', '03/09/2000','01/07/2016','Java, networking');

insert into HDZ_jobhistory (jobhistoryid,jobhistoryflag,applicantID, position, companyname, startdate,enddate, description ) 
values (hdz_jobhistory_id_seq.nextval,null, 1,' Senior Software Engineer', 'Oracle', '08/05/2011','01/07/2015','Java Programmer,Adop');



create table HDZ_reftable(
refid integer primary key,
refflag varchar2(1),
applicantid integer,
refname varchar2(50) ,
refemail varchar2(200) ,
refphone varchar2(200) ,
refposition varchar2(200) ,
CONSTRAINT fk_HDZ_reftable_applicantID FOREIGN KEY (applicantID) references HDZ_applicant(applicantID)
);

insert into HDZ_reftable (refid,refflag, applicantID,refname, refemail, refphone,refposition ) 
values (hdz_reftable_id_seq.nextval,null, 1,'Bob', 'bob@gmail.com', '2029940771','Senior Software Engineer');

insert into HDZ_reftable (refid,refflag, applicantID,refname, refemail, refphone,refposition ) 
values (hdz_reftable_id_seq.nextval,null, 2,'jesica', 'jesica@gmail.com', '3019940771','Senior Software Engineer');

insert into HDZ_reftable (refid,refflag, applicantID,refname, refemail, refphone,refposition ) 
values (hdz_reftable_id_seq.nextval,null, 3,'rooney', 'rooney@gmail.com', '5987432160','Senior Software Engineer');

insert into HDZ_reftable (refid,refflag, applicantID,refname, refemail, refphone,refposition ) 
values (hdz_reftable_id_seq.nextval,null, 4,'he', 'he@gmail.com', '5467893212','Senior Software Engineer');

insert into HDZ_reftable (refid,refflag, applicantID,refname, refemail, refphone,refposition ) 
values (hdz_reftable_id_seq.nextval,null, 1,'su', 'su@gmail.com', '2015897844','Senior Software Engineer');

create table HDZ_positions(
positionid integer primary key,
positiontype varchar2(50),
position varchar2(50)
);

insert into HDZ_positions(positionid, positiontype, position)
values (hdz_positions_id_seq.nextval, 'developer', 'Software Engineer');
insert into HDZ_positions(positionid, positiontype, position)
values (hdz_positions_id_seq.nextval, 'non-developer', 'Hardware Engineer');
insert into HDZ_positions(positionid, positiontype, position)
values (hdz_positions_id_seq.nextval, 'non-developer', 'Quality Assurance');
insert into HDZ_positions(positionid, positiontype, position)
values (hdz_positions_id_seq.nextval, 'non-developer', 'Cybersecurity');
insert into HDZ_positions(positionid, positiontype, position)
values (hdz_positions_id_seq.nextval, 'developer', 'Senior Software Engineer');
insert into HDZ_positions(positionid, positiontype, position)
values (hdz_positions_id_seq.nextval, 'developer', 'Entry level graduate');


create table HDZ_jobs(
jobsid integer primary key,
positionid integer,
numberopenings number,
description varchar2(200),
overallexperience number,
CONSTRAINT fk_HDZ_jobs_positionid FOREIGN KEY (positionid) references HDZ_positions (positionid)
);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 1, 5, 'Mid-level Java Software Engineer', 3);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 1, 5, 'Java Software Engineer', 3);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 1, 5, 'Web Developer 1', 2);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 2, 5, 'ASIC CPU Design and Testing', 2);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 3, 5, 'Software testing', 1);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 3, 5, 'Quality Assurance', 2);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 3, 5, 'Quality Assurance Analyst', 3);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 4, 5, 'Cybersecurity Analyst 1', 1);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 4, 5, 'Digital Forensics Specialist', 3);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 4, 5, 'Cybersecurity Threat Senior Analyst', 5);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 5, 5, 'Senior Java Developer', 5);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 5, 5, 'Full Stack Senior Software Engineer', 5);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 6, 5, 'Entry level Java Programmer', 0);

insert into HDZ_Jobs (jobsid, positionid, numberopenings, description, overallexperience)
values (hdz_jobs_id_seq.nextval, 6, 5, 'Entry level web development', 0);


create table HDZ_application(
applicationid integer primary key,
applicantid integer ,
codingtest varchar2(1),
score number,
jobsid integer ,
appstatus varchar2(50) ,
comments varchar2(500) ,
CONSTRAINT fk_HDZ_application_applicantID FOREIGN KEY (applicantID) references HDZ_applicant(applicantID),
CONSTRAINT fk_HDZ_application_jobsid FOREIGN KEY (jobsid) references HDZ_jobs(jobsid)
);

insert into HDZ_application (applicationid, applicantID, codingtest, score, jobsID, appstatus, comments)
values (hdz_application_id_seq.nextval, 1,'G', null, 1,'New',null);

insert into HDZ_application (applicationid, applicantID, codingtest, score, jobsID, appstatus, comments)
values (hdz_application_id_seq.nextval, 1,'G', null, 2,'New',null);

insert into HDZ_application (applicationid, applicantID, codingtest, score, jobsID, appstatus, comments)
values (hdz_application_id_seq.nextval, 1,'G', null, 6,'New',null);

insert into HDZ_application (applicationid, applicantID, codingtest, score, jobsID, appstatus, comments)
values (hdz_application_id_seq.nextval, 2, 'N', null, 2,'New',null);

insert into HDZ_application (applicationid, applicantID, codingtest, score, jobsID, appstatus, comments)
values (hdz_application_id_seq.nextval, 3, 'N', null, 3,'New',null);

insert into HDZ_application (applicationid, applicantID, codingtest, score, jobsID, appstatus, comments)
values (hdz_application_id_seq.nextval, 3, 'N', null, 2,'New',null);

insert into HDZ_application (applicationid, applicantID, codingtest, score, jobsID, appstatus, comments)
values (hdz_application_id_seq.nextval, 4,'G', null, 4,'New',null);

insert into HDZ_application (applicationid, applicantID, codingtest, score, jobsID, appstatus, comments)
values (hdz_application_id_seq.nextval, 5,'G', null, 5,'New',null);


create table HDZ_employee(
employeeid integer primary key,
empname varchar2(50) ,
email varchar2(100) ,
hashedpwd varchar2(200) ,
salt varchar2(200),
position varchar2(100),
gravatarurl varchar2(200)
);

insert into HDZ_employee (employeeid, empname,email,hashedpwd, salt, position, gravatarurl)
values (hdz_employee_id_seq.nextval,'Dave','dave@gmail.com','e95a5ad51f4af4ea83c652fbc74796ed413cff1fde20b01e29b7b749ad109d49', 'sFr6YJz/jKBZi8GPvtVz576kytszrhcj/kaSp9MZ2q0=', 'HR Manager', 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position, gravatarurl)
values (hdz_employee_id_seq.nextval,'Sam','sam@gmail.com','ea46ff538d38fce90d9f6a177cb2c538e25f44a5deb47725115913ffc93ceaf2', 'W7BnXZhU/efVeOCaXEnfkI3L9s1vOfEZCYfE7+93D0k=','Compliance Officer', 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position, gravatarurl)
values (hdz_employee_id_seq.nextval,'Juli','juli@gmail.com','8d9bd9192e2eed579d92ca4995289febcee969fa57979dde0feb5f6477427620', 'zYWAq2b39MEkGgcA1oXK5owfdtVFQad++2tK7futvAA=','HR Assistant', 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position, gravatarurl)
values (hdz_employee_id_seq.nextval,'Sue','sue@gmail.com','34f78a77941dacb64b5010a3cd3971295982d9b6583fc8dbe770311c4f24b5b4', 'cFcwYn6sDNpz75L8qaLsqzZ2tqoz5BnqUdRw3JqYnNw=','HR Specialist', 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position, gravatarurl)
values (hdz_employee_id_seq.nextval,'Dan','dan@gmail.com','f6833b84e13b10b6185323b9117c7f8352016b788b4bda9fe87f4b114d0c412a', 'V33qAk8La7ZncEff4K1ipai+xoJHk4MNK/iT8pUb840=','Health Care Professional', 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position, gravatarurl)
values (hdz_employee_id_seq.nextval,'Alton','alton@gmail.com','efe23baaeab3beb3e20fe2f5b685954c91eb20dbd32f249a874222a7206bd328', 'bn7XeEdjscm0UG2BN/kMSsjyvjXhr6Hb77ylnzV+daA=','Hiring Manager', 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position, gravatarurl)
values (hdz_employee_id_seq.nextval,'Zordon','zordon@gmail.com','6fb2efa4a8e5400c5221ba6d477cecf1c5882da97f637b920dd937e80f6d5c0c', 'Vnrv9zSKght2ZxjfbgDm4l3hZjOyflds+jToFpM+7Ww=','Hiring Manager', 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position, gravatarurl)
values (hdz_employee_id_seq.nextval,'Ann','ann@gmail.com','d282629e2143c410906d323e34e4e590b59f208ea4e6c75c33f01d25f17d99c5', 'OBoalEdLrRKcUoWUOs/XyZGs6RLBjjwkY6SjAHshLfE=','Software Engineer', 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position, gravatarurl)
values (hdz_employee_id_seq.nextval,'Tim','tim@gmail.com','9f0904b141429568059b455e923cc773f17c549f60c07a40316bbcb184df64d4', 'RNPmzBI6B4O+r+FUnPcKt1RNP/UdrrEF+KTmbQyUAjM=','Technology analyst', 'https://www.gravatar.com/avatar/f71c867b63a10eac797275abe231cb31?s=50');


create table HDZ_jobskills(
jobskillsid integer primary key,
jobskills varchar2(200),
jobexperience number,
jobsid integer ,
CONSTRAINT fk_HDZ_jobskills_jobsid FOREIGN KEY (jobsID) references HDZ_jobs(jobsID)
);

insert into HDZ_jobskills (jobskillsid, jobskills, jobexperience, jobsid)
values (hdz_jobskills_id_seq.nextval, 'Java', 2.0, 1);
insert into HDZ_jobskills (jobskillsid, jobskills, jobexperience, jobsid)
values (hdz_jobskills_id_seq.nextval, 'JSP', 2.0, 1);
insert into HDZ_jobskills (jobskillsid, jobskills, jobexperience, jobsid)
values (hdz_jobskills_id_seq.nextval, 'HTML', 2.0, 1);
insert into HDZ_jobskills (jobskillsid, jobskills, jobexperience, jobsid)
values (hdz_jobskills_id_seq.nextval, 'XML', 2.0, 1);
insert into HDZ_jobskills (jobskillsid, jobskills, jobexperience, jobsid)
values (hdz_jobskills_id_seq.nextval, 'CSS', 2.0, 1);
insert into HDZ_jobskills (jobskillsid, jobskills, jobexperience, jobsid)
values (hdz_jobskills_id_seq.nextval, 'Javascript', 2.0, 1);
insert into HDZ_jobskills (jobskillsid, jobskills, jobexperience, jobsid)
values (hdz_jobskills_id_seq.nextval, 'Jquery', 2.0, 1);
insert into HDZ_jobskills (jobskillsid, jobskills, jobexperience, jobsid)
values (hdz_jobskills_id_seq.nextval, 'Bootstrap', 2.0, 1);
create table HDZ_applicantskills(
applicantskillsid integer primary key,
applicantid integer ,
skills varchar2(200),
experience number,
CONSTRAINT fk_applicantskills_applicantID FOREIGN KEY (applicantID) references HDZ_applicant(applicantID)
);

insert into HDZ_applicantskills(applicantskillsid, applicantid, skills, experience)
values (hdz_applicantskills_id_seq.nextval, 1, 'JSP', 2.5);
insert into HDZ_applicantskills(applicantskillsid, applicantid, skills, experience)
values (hdz_applicantskills_id_seq.nextval, 1, 'Java', 2.5);
insert into HDZ_applicantskills(applicantskillsid, applicantid, skills, experience)
values (hdz_applicantskills_id_seq.nextval, 1,  'HTML', 2.5);
insert into HDZ_applicantskills(applicantskillsid, applicantid, skills, experience)
values (hdz_applicantskills_id_seq.nextval, 1, 'CSS', 2.5);
insert into HDZ_applicantskills(applicantskillsid, applicantid, skills, experience)
values (hdz_applicantskills_id_seq.nextval, 1, 'Servelets', 2.5);
insert into HDZ_applicantskills(applicantskillsid, applicantid, skills, experience)
values (hdz_applicantskills_id_seq.nextval, 2, 'Java', 2.5);
values (hdz_applicantskills_id_seq.nextval, 2, 'C#', 2.5);
insert into HDZ_applicantskills(applicantskillsid, applicantid, skills, experience)
values (hdz_applicantskills_id_seq.nextval, 3, 'C#', 2.5);

create table HDZ_jobquestions(
jobquestionsid integer primary key,
positionid integer,
interviewtype varchar2(50),
jobquestion varchar2(1000),
CONSTRAINT fk_HDZ_jobquestions_positionid FOREIGN KEY (positionid) references HDZ_positions (positionid)
);

-- run the jobsquestions script separately


create table HDZ_tests(
testsid integer primary key,
applicationid integer,
codinglanguage varchar2(50),
testresponse varchar2(2000),
jobquestionsid integer,
CONSTRAINT fk_HDZ_tests_applicationid FOREIGN KEY (applicationid) references HDZ_application(applicationid),
CONSTRAINT fk_HDZ_tests_jobquestionsid FOREIGN KEY (jobquestionsid) references HDZ_jobquestions(jobquestionsid)
);

commit;

select * from HDZ_employee;

select * from HDZ_applicant;

--update hdz_applicant set employeeflag = 'N' where employeeflag is null;


select * from HDZ_Applicantskills;

-- run the jobsquestions script separately


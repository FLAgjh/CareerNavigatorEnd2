create schema  careernavigator;
create table account
(
    username  varchar(20)  not null
        primary key,
    password  varchar(400) null,
    avatarUrl text         null,
    type      int          null
);

create table ansrecord
(
    id       int auto_increment
        primary key,
    username varchar(20) null comment '用户名',
    paperid  int         null comment '试卷id',
    exeId    int         null comment '题目id',
    op       varchar(20) null comment '选项',
    constraint ansrecord_ibfk_1
        foreign key (username) references account (username)
);

create index username
    on ansrecord (username);

create table assessment
(
    id             int auto_increment
        primary key,
    paperid        int         null comment '试卷id',
    username       varchar(20) null comment '用户名',
    analysis       text        null comment '分析',
    advice         text        null comment '建议',
    assessmenttime varchar(50) null comment '评估时间',
    constraint assessment_ibfk_1
        foreign key (username) references account (username)
);

create index username
    on assessment (username);

create table interview
(
    id            int auto_increment
        primary key,
    username      varchar(20) null comment '用户名',
    jobname       varchar(20) null comment '岗位名称',
    jobtype       varchar(20) null comment '岗位类型',
    interviewtime varchar(50) null comment '面试时间',
    score         int         null comment '面试评分',
    analysis      text        null comment '面试分析',
    advice        text        null comment '面试建议',
    review        text        null comment '面试回顾',
    constraint interview_ibfk_1
        foreign key (username) references account (username)
);

create table chat
(
    id          int auto_increment
        primary key,
    msg         text        null comment '消息内容',
    interviewid int         null comment '面试id',
    chattime    varchar(50) null comment '发送时间',
    role        varchar(20) null comment '角色',
    constraint chat_ibfk_1
        foreign key (interviewid) references interview (id)
);

create index interviewid
    on chat (interviewid);

create index username
    on interview (username);

create table job
(
    id             int auto_increment
        primary key,
    jobname        varchar(20) null comment '岗位名称',
    company        varchar(50) null comment '公司名称',
    salary         varchar(20) null comment '薪资',
    location       varchar(50) null comment '工作地点',
    experience     varchar(20) null comment '经验要求',
    education      varchar(20) null comment '学历要求',
    jobtype        varchar(20) null comment '岗位类型',
    jobdescription text        null comment '岗位描述',
    requirement    text        null comment '任职要求',
    publishdate    varchar(50) null comment '发布时间'
);

create table comment
(
    id          int auto_increment
        primary key,
    username    varchar(20) null comment '用户名',
    jobid       int         null comment '岗位id',
    commentdate varchar(50) null comment '评论时间',
    content     text        null comment '评论内容',
    type        varchar(10) null comment '评论类型',
    fatherid    int         null comment '父评论id',
    constraint comment_ibfk_1
        foreign key (username) references account (username),
    constraint comment_ibfk_2
        foreign key (jobid) references job (id)
);

create index jobid
    on comment (jobid);

create index username
    on comment (username);

create table jobapply
(
    id        int auto_increment
        primary key,
    username  varchar(20) null comment '用户名',
    jobid     int         null comment '岗位id',
    applydate varchar(50) null comment '申请时间',
    status    varchar(20) null comment '申请状态',
    constraint jobapply_ibfk_1
        foreign key (username) references account (username),
    constraint jobapply_ibfk_2
        foreign key (jobid) references job (id)
);

create index jobid
    on jobapply (jobid);

create index username
    on jobapply (username);

create table resume
(
    id         int auto_increment
        primary key,
    username   varchar(20) null comment '用户名',
    title      varchar(20) null comment '简历标题',
    createtime varchar(50) null comment '创建时间',
    score      int         null comment '简历评分',
    analysis   text        null comment '简历分析',
    advice     text        null comment '简历建议',
    type       varchar(20) null comment '简历类型'
);

create table education
(
    eduid     int auto_increment
        primary key,
    id        int         null comment '标识',
    school    varchar(50) null comment '学校',
    degree    varchar(20) null comment '学历',
    major     varchar(20) null comment '专业',
    startDate varchar(50) null comment '开始时间',
    endDate   varchar(50) null comment '结束时间',
    resumeid  int         null comment '简历id',
    constraint education_ibfk_1
        foreign key (resumeid) references resume (id)
);

create index resumeid
    on education (resumeid);

create table honors
(
    honorid     int auto_increment
        primary key,
    id          int         null comment '标识',
    honorName   varchar(50) null comment '荣誉',
    date        varchar(50) null comment '时间',
    description text        null comment '描述',
    resumeid    int         null comment '简历id',
    constraint honors_ibfk_1
        foreign key (resumeid) references resume (id)
);

create index resumeid
    on honors (resumeid);

create table personalinfo
(
    id                  int auto_increment
        primary key,
    name                varchar(30)  null comment '姓名',
    gender              varchar(10)  null comment '性别',
    phone               varchar(20)  null comment '手机号',
    email               varchar(50)  null comment '邮箱',
    university          varchar(50)  null comment '学校',
    politicalStatus     varchar(20)  null comment '政治面貌',
    website             varchar(50)  null comment '个人网站',
    avatar              varchar(50)  null comment '头像',
    major               varchar(20)  null comment '专业',
    age                 int          null comment '年龄',
    applicationPosition varchar(100) null comment '申请岗位',
    resumeid            int          null comment '简历id',
    constraint personalinfo_ibfk_1
        foreign key (resumeid) references resume (id)
);

create index resumeid
    on personalinfo (resumeid);

create table projects
(
    projectid         int auto_increment
        primary key,
    id                int         null comment '标识',
    projectName       varchar(50) null comment '项目名称',
    role              varchar(20) null comment '角色',
    startDate         varchar(50) null comment '开始时间',
    endDate           varchar(50) null comment '结束时间',
    description       text        null comment '描述',
    briefIntroduction text        null comment '项目简介',
    resumeid          int         null comment '简历id',
    constraint projects_ibfk_1
        foreign key (resumeid) references resume (id)
);

create index resumeid
    on projects (resumeid);

create table resumesetting
(
    settingid          int auto_increment
        primary key,
    id                 int         null comment '标识',
    resumeid           int         null comment '简历id',
    themeColor1        varchar(20) null comment '主题颜色1',
    themeColor2        varchar(20) null comment '主题颜色2',
    fontSize           int         null comment '字体大小',
    sectionSpacing     int         null comment '段落间距',
    paragraphSpacing   int         null comment '段落间距',
    currentTemplate    varchar(50) null comment '当前模板',
    padding_top_bottom int         null comment '内边距',
    padding_left_right int         null comment '内边距',
    constraint resumesetting_ibfk_1
        foreign key (resumeid) references resume (id)
);

create index resumeid
    on resumesetting (resumeid);

create table skills
(
    skillid   int auto_increment
        primary key,
    id        int         null comment '标识',
    skillName varchar(50) null comment '技能',
    resumeid  int         null comment '简历id',
    constraint skills_ibfk_1
        foreign key (resumeid) references resume (id)
);

create index resumeid
    on skills (resumeid);

create table summary
(
    summaryid int auto_increment
        primary key,
    summary   text null comment '总结',
    resumeid  int  null comment '简历id',
    constraint summary_ibfk_1
        foreign key (resumeid) references resume (id)
);

create index resumeid
    on summary (resumeid);

create table user
(
    id             int auto_increment
        primary key,
    username       varchar(20) null comment '用户名',
    nickname       varchar(40) null comment '昵称',
    sex            varchar(10) null comment '性别',
    age            int         null comment '年龄',
    education      varchar(20) null comment '教育水平',
    major          varchar(20) null comment '专业',
    tel            varchar(20) null comment '手机号',
    email          varchar(50) null comment '邮箱',
    expectedjob    varchar(20) null comment '意向岗位',
    graduationtime varchar(50) null comment '毕业时间',
    registertime   varchar(50) null comment '注册时间',
    constraint user_ibfk_1
        foreign key (username) references account (username)
);

create index username
    on user (username);

create table workexperience
(
    workid      int auto_increment
        primary key,
    id          int         null comment '标识',
    company     varchar(50) null comment '公司',
    position    varchar(20) null comment '职位',
    startDate   varchar(50) null comment '开始时间',
    endDate     varchar(50) null comment '结束时间',
    description text        null comment '描述',
    resumeid    int         null comment '简历id',
    constraint workexperience_ibfk_1
        foreign key (resumeid) references resume (id)
);

create index resumeid
    on workexperience (resumeid);


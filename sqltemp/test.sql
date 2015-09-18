SELECT S.sid,T.tid
FROM stuhealthy.student S,stuhealthy.major_information M,stuhealthy.faculty_information F,stuhealthy.teacher T
WHERE S.major = M.mid and M.belong = F.fid and F.tid = T.tid
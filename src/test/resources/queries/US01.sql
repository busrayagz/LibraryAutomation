select id,full_name,email,password,user_group_id,image,
       extra_data,status,is_admin,start_date,end_date,address from users;

select count(*) from users;

select count(distinct id) from users;

select id from users;
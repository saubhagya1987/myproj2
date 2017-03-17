

CREATE TABLE IF NOT EXISTS `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(256) DEFAULT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE IF NOT EXISTS `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `client_oauth_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`) VALUES
('golenchi', 'golenchiRestAPI', 'secret', 'trust, read, write', 'password,authorization_code,refresh_token,implicit', NULL, 'ROLE_USER', 50000, 50000, NULL, '1');



INSERT INTO `client_oauth_details` 
(`client_id`, `resource_ids`, 
`client_secret`, `scope`,
 `authorized_grant_types`, 
`authorities`, `access_token_validity`,
 `refresh_token_validity` ) VALUES
('golenchi', 'golenchiRestAPI', 
'secret', 'trust, read, write', 
'password,authorization_code,refresh_token,implicit', 'ROLE_USER', 50000, 50000);


INSERT INTO `user` (`user_id`, `email_address`, `first_name`, `last_name`, `password`, `status`, `username`  ) VALUES
('1', 'testUser@gmail.com',  'firstName', 'LastName','xyz123', '1', 'testUser');

INSERT INTO `role` (`role_id`, `description`, `name` ) VALUES ('1', 'ROLE_USER','USER');

INSERT INTO `role_features` (`role_id`, `feature` ) VALUES ('1', 'USER');

INSERT INTO user_role (`user_id`, `role_id` ) VALUES ('1', '1');


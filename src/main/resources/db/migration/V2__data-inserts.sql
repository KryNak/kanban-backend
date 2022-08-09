INSERT INTO boards (id, name) VALUES ('2128b4ad-ecc2-4c1e-af8f-cd500c26af6f', 'Platform Launch');
INSERT INTO boards (id, name) VALUES ('268f63a7-6fad-450e-8690-bd50b1418ec3', 'Marketing Plan');
INSERT INTO boards (id, name) VALUES ('41c31dca-798b-42fe-a9f5-385ff68a1dda', 'Roadmap');



INSERT INTO columns (id, name, board_id, position) VALUES ('392e7e88-fcd7-4a85-bc34-e9b2157ec8d9', 'Todo', '2128b4ad-ecc2-4c1e-af8f-cd500c26af6f', 0);
INSERT INTO columns (id, name, board_id, position) VALUES ('79ae8140-76f5-4c6a-b321-6b414565d8d6', 'Doing', '2128b4ad-ecc2-4c1e-af8f-cd500c26af6f', 1);
INSERT INTO columns (id, name, board_id, position) VALUES ('3a66140a-51be-430f-bc6b-72167588bebc', 'Done', '2128b4ad-ecc2-4c1e-af8f-cd500c26af6f', 2);
INSERT INTO columns (id, name, board_id, position) VALUES ('d320fba9-38d9-4267-9b76-d9992a260a59', 'Todo', '268f63a7-6fad-450e-8690-bd50b1418ec3', 0);
INSERT INTO columns (id, name, board_id, position) VALUES ('5a10bfaf-9114-4108-9dfe-8d5148bff184', 'Doing', '268f63a7-6fad-450e-8690-bd50b1418ec3', 1);
INSERT INTO columns (id, name, board_id, position) VALUES ('e6d95665-f88e-4a62-8d82-b0b83ea7bfaa', 'Done', '268f63a7-6fad-450e-8690-bd50b1418ec3', 2);
INSERT INTO columns (id, name, board_id, position) VALUES ('902861d4-dce6-4359-a033-12645361a90d', 'Now', '41c31dca-798b-42fe-a9f5-385ff68a1dda', 0);
INSERT INTO columns (id, name, board_id, position) VALUES ('51368d5a-26ea-4496-8251-387798f4bda2', 'Next', '41c31dca-798b-42fe-a9f5-385ff68a1dda', 1);
INSERT INTO columns (id, name, board_id, position) VALUES ('89666704-33ca-488a-a2ad-1dcd3165ca61', 'Later', '41c31dca-798b-42fe-a9f5-385ff68a1dda', 2);



INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('b40bca71-ec48-4ef5-8056-a198a0c07ff2', '', 'Todo', 'Build UI for onboarding flow', '392e7e88-fcd7-4a85-bc34-e9b2157ec8d9', 0);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('cb60866f-cbfa-4bb9-bd30-8f1954785e52', '', 'Todo', 'Build UI for search', '392e7e88-fcd7-4a85-bc34-e9b2157ec8d9', 1);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('e3e78513-eeff-4249-b011-b33c58bd98af', '', 'Todo', 'Build settings UI', '392e7e88-fcd7-4a85-bc34-e9b2157ec8d9', 2);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('59a34667-989a-4eb1-8ab8-4643020312f1', 'Once we feel version one is ready, we need to rigorously test it both internally and externally to identify any major gaps.', 'Todo', 'QA and test all major user journeys', '392e7e88-fcd7-4a85-bc34-e9b2157ec8d9', 3);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('d7b47eb6-42f7-4c43-a02f-0cf933c541f4', '', 'Doing', 'Design settings and search pages', '79ae8140-76f5-4c6a-b321-6b414565d8d6', 0);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('66c9bb26-b103-4714-800a-d81ede65e251', '', 'Doing', 'Add account management endpoints', '79ae8140-76f5-4c6a-b321-6b414565d8d6', 1);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('716ffa4e-6127-4a68-bf20-b6cab8657041', '', 'Doing', 'Design onboarding flow', '79ae8140-76f5-4c6a-b321-6b414565d8d6', 2);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('19773737-d32d-41c3-af1e-8e000d1ac5c2', '', 'Doing', 'Add search enpoints', '79ae8140-76f5-4c6a-b321-6b414565d8d6', 3);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('18fd96ce-a401-4210-aa45-b8f9355d2a5e', '', 'Doing', 'Add authentication endpoints', '79ae8140-76f5-4c6a-b321-6b414565d8d6', 4);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('7c9f94a9-81c4-44fc-8dad-1bb6224f2ec6', 'We know what we''re planning to build for version one. Now we need to finalise the first pricing model we''ll use. Keep iterating the subtasks until we have a coherent proposition.', 'Doing', 'Research pricing points of various competitors and trial different business models', '79ae8140-76f5-4c6a-b321-6b414565d8d6', 5);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('a14de4a5-9c2b-46eb-a71c-6ba03779fc19', 'Ensure the layout continues to make sense and we have strong buy-in from potential users.', 'Done', 'Conduct 5 wireframe tests', '3a66140a-51be-430f-bc6b-72167588bebc', 0);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('26b45d15-7a0a-4d60-b5bb-e0b5ee269411', 'Create a greyscale clickable wireframe prototype to test our asssumptions so far.', 'Done', 'Create wireframe prototype', '3a66140a-51be-430f-bc6b-72167588bebc', 1);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('894d8d19-1de2-43d0-9eac-fb3622fa844e', 'Keep iterating through the subtasks until we''re clear on the core concepts for the app.', 'Done', 'Review results of usability tests and iterate', '3a66140a-51be-430f-bc6b-72167588bebc', 2);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('61dafd04-bc42-4704-8edc-8874b481b664', '', 'Done', 'Create paper prototypes and conduct 10 usability tests with potential customers', '3a66140a-51be-430f-bc6b-72167588bebc', 3);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('ac14c6ac-b940-4157-b9b0-2a2d6fa3e16f', 'We need to define and refine our core product. Interviews will help us learn common pain points and help us define the strongest MVP.', 'Done', 'Market discovery', '3a66140a-51be-430f-bc6b-72167588bebc', 4);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('efc759ca-1d97-4a47-93b2-2358dc474422', '', 'Done', 'Competitor analysis', '3a66140a-51be-430f-bc6b-72167588bebc', 5);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('b3d1dd79-a90e-4c4c-a493-adddc33c90ba', 'We need to get a solid overview of the market to ensure we have up-to-date estimates of market size and demand.', 'Done', 'Research the market', '3a66140a-51be-430f-bc6b-72167588bebc', 6);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('64fb3513-05b3-4d62-9760-bb64a3e2e34c', '', 'Todo', 'Plan Product Hunt launch', 'd320fba9-38d9-4267-9b76-d9992a260a59', 0);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('c54f74a3-e316-4c6f-8456-b18e790a3810', '', '', 'Share on Show HN', 'd320fba9-38d9-4267-9b76-d9992a260a59', 1);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('a8750291-9478-478b-884b-5bf7149d4194', '', '', 'Write launch article to publish on multiple channels', 'd320fba9-38d9-4267-9b76-d9992a260a59', 2);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('04ecce7b-d652-4033-80f6-d0e92ba541a7', '', '', 'Launch version one', '902861d4-dce6-4359-a033-12645361a90d', 0);
INSERT INTO tasks (id, description, status, title, column_id, position) VALUES ('0cdf8d22-f45d-4a05-ae27-8e9e6621b560', 'Beyond the initial launch, we''re keeping the initial roadmap completely empty. This meeting will help us plan out our next steps based on actual customer feedback.', '', 'Review early feedback and plan next steps for roadmap', '902861d4-dce6-4359-a033-12645361a90d', 1);



INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('da976fd6-d90b-4e83-98d3-2231d3622068', true, 'Sign up page', 'b40bca71-ec48-4ef5-8056-a198a0c07ff2', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('bf27cf75-f1af-4e76-b9da-c24a4c8afd6e', false, 'Sign in page', 'b40bca71-ec48-4ef5-8056-a198a0c07ff2', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('892bf056-05f9-4cdb-8fcd-847449bfcabd', false, 'Welcome page', 'b40bca71-ec48-4ef5-8056-a198a0c07ff2', 2);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('c1f809bc-fade-4817-b110-6f57e275a6b6', false, 'Search page', 'cb60866f-cbfa-4bb9-bd30-8f1954785e52', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('d304862f-ceb4-44fd-8d72-e51b4207c1f0', false, 'Account page', 'e3e78513-eeff-4249-b011-b33c58bd98af', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('8c7c0c5b-aada-4c7c-8391-e183cb9f0961', false, 'Billing page', 'e3e78513-eeff-4249-b011-b33c58bd98af', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('a5677099-4801-4378-ac23-c9752d4e7a10', false, 'Internal testing', '59a34667-989a-4eb1-8ab8-4643020312f1', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('d90b53dd-b816-479d-9a43-ef49a15e5dd9', false, 'External testing', '59a34667-989a-4eb1-8ab8-4643020312f1', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('b08fbae7-d8fc-466d-b4f7-a776ac2518f0', true, 'Settings - Account page', 'd7b47eb6-42f7-4c43-a02f-0cf933c541f4', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('6e5c9e7c-c036-4d82-a73c-a8cad8b7a05e', true, 'Settings - Billing page', 'd7b47eb6-42f7-4c43-a02f-0cf933c541f4', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('8a62b672-282f-4c31-b6c8-5fa18e788a67', false, 'Search page', 'd7b47eb6-42f7-4c43-a02f-0cf933c541f4', 2);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('16f38fff-6fdc-4493-8012-cd34100b625d', true, 'Upgrade plan', '66c9bb26-b103-4714-800a-d81ede65e251', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('70f2cd8c-8e28-421e-8c0e-75e75990ec3b', true, 'Cancel plan', '66c9bb26-b103-4714-800a-d81ede65e251', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('076fc4f4-5f98-448f-925c-b4ec04423779', false, 'Update payment method', '66c9bb26-b103-4714-800a-d81ede65e251', 2);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('6d4fc1ed-59c6-4068-8e2b-0f99a18789fd', true, 'Sign up page', '716ffa4e-6127-4a68-bf20-b6cab8657041', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('785b0e6d-b639-4187-a3be-09401e42a3ff', false, 'Sign in page', '716ffa4e-6127-4a68-bf20-b6cab8657041', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('b25006a3-d0eb-4a66-8647-bbeec304e40b', false, 'Welcome page', '716ffa4e-6127-4a68-bf20-b6cab8657041', 2);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('55d4bedb-564f-443f-9fe0-a8a19070fa80', true, 'Add search endpoint', '19773737-d32d-41c3-af1e-8e000d1ac5c2', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('fcdf78c2-2f07-4a45-873c-ca69c7935d4b', false, 'Define search filters', '19773737-d32d-41c3-af1e-8e000d1ac5c2', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('266a68df-153f-4476-8b9a-00bf0edb1591', true, 'Define user model', '18fd96ce-a401-4210-aa45-b8f9355d2a5e', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('0823394d-8652-4770-99be-c41d46992035', false, 'Add auth endpoints', '18fd96ce-a401-4210-aa45-b8f9355d2a5e', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('beec502c-c9b0-4fc4-b149-9e96e4499ed4', true, 'Research competitor pricing and business models', '7c9f94a9-81c4-44fc-8dad-1bb6224f2ec6', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('0ca8f6ad-46b2-4d1e-acef-cdb55c7098b1', false, 'Outline a business model that works for our solution', '7c9f94a9-81c4-44fc-8dad-1bb6224f2ec6', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('ba46f7bc-1302-46af-a574-366e5a7d84a8', false, 'Talk to potential customers about our proposed solution and ask for fair price expectancy', '7c9f94a9-81c4-44fc-8dad-1bb6224f2ec6', 2);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('a070a4ff-b8b4-4669-91e6-5326caa064e9', true, 'Complete 5 wireframe prototype tests', 'a14de4a5-9c2b-46eb-a71c-6ba03779fc19', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('b5c9541a-b85c-4631-8ede-168a029c856f', true, 'Create clickable wireframe prototype in Balsamiq', '26b45d15-7a0a-4d60-b5bb-e0b5ee269411', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('5a8a33cc-911d-4d86-8ab6-b5229a1ee855', true, 'Meet to review notes from previous tests and plan changes', '894d8d19-1de2-43d0-9eac-fb3622fa844e', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('011f2ace-4606-4266-a152-76e84330b362', true, 'Make changes to paper prototypes', '894d8d19-1de2-43d0-9eac-fb3622fa844e', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('2c7f87a4-28b8-400a-a453-a28fdca6e851', true, 'Conduct 5 usability tests', '894d8d19-1de2-43d0-9eac-fb3622fa844e', 2);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('45e351fa-c92f-484c-896a-f02ea837bd78', true, 'Create paper prototypes for version one', '61dafd04-bc42-4704-8edc-8874b481b664', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('04f401ad-4e5a-4ad8-99b4-676c9fb99722', true, 'Complete 10 usability tests', '61dafd04-bc42-4704-8edc-8874b481b664', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('5afca395-9d5d-49c4-839e-64820352e63f', true, 'Interview 10 prospective customers', 'ac14c6ac-b940-4157-b9b0-2a2d6fa3e16f', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('076e4a1d-9094-4fa9-bb1c-03b211d15807', true, 'Find direct and indirect competitors', 'efc759ca-1d97-4a47-93b2-2358dc474422', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('8b24dc9a-21ce-4f76-a691-d5a4a5d870a3', true, 'SWOT analysis for each competitor', 'efc759ca-1d97-4a47-93b2-2358dc474422', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('4c5ff30e-6078-4746-801a-dce1ed4f6d12', true, 'Write up research analysis', 'b3d1dd79-a90e-4c4c-a493-adddc33c90ba', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('d2905774-1a91-4c4b-b262-d9167bd85b0e', true, 'Calculate TAM', 'b3d1dd79-a90e-4c4c-a493-adddc33c90ba', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('bd0cad75-5f40-43f7-a799-216c5e92f8db', false, 'Find hunter', '64fb3513-05b3-4d62-9760-bb64a3e2e34c', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('da9d9072-2c99-42ae-bada-e604bb803c7c', false, 'Gather assets', '64fb3513-05b3-4d62-9760-bb64a3e2e34c', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('5807912a-f088-4c00-afa6-c32c2db0c074', false, 'Draft product page', '64fb3513-05b3-4d62-9760-bb64a3e2e34c', 2);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('893ee3a9-f48c-4425-a361-62023c848d5e', false, 'Notify customers', '64fb3513-05b3-4d62-9760-bb64a3e2e34c', 3);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('4d3046c9-3b28-4fbb-9e34-31e7ab749e1e', false, 'Notify network', '64fb3513-05b3-4d62-9760-bb64a3e2e34c', 4);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('8c2a9e81-228f-4ed2-b608-bb7c5a9f8f31', false, 'Launch!', '64fb3513-05b3-4d62-9760-bb64a3e2e34c', 5);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('643ee700-d2e2-4fc5-85b1-11a196804542', false, 'Draft out HN post', 'c54f74a3-e316-4c6f-8456-b18e790a3810', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('b1dc56bf-fd85-46d0-8aa3-8daba53441c5', false, 'Get feedback and refine', 'c54f74a3-e316-4c6f-8456-b18e790a3810', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('762ae33d-b55e-40c7-80fa-0116945476d4', false, 'Publish post', 'c54f74a3-e316-4c6f-8456-b18e790a3810', 2);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('87501671-2e01-46b4-81eb-66f595afc427', false, 'Write article', 'a8750291-9478-478b-884b-5bf7149d4194', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('44b02c56-5a8e-43df-a88e-9c41a2651757', false, 'Publish on LinkedIn', 'a8750291-9478-478b-884b-5bf7149d4194', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('47d93499-9c7d-49b7-9416-296377e9f270', false, 'Publish on Inndie Hackers', 'a8750291-9478-478b-884b-5bf7149d4194', 2);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('d776c086-072a-4807-9ab9-116c54acf9fd', false, 'Publish on Medium', 'a8750291-9478-478b-884b-5bf7149d4194', 3);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('a7b47633-d2f3-46db-878f-46494e14a98d', false, 'Launch privately to our waitlist', '04ecce7b-d652-4033-80f6-d0e92ba541a7', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('85e3b463-5b08-4c52-a55b-6eca503fad3d', false, 'Launch y on PH, HN, etc.', '04ecce7b-d652-4033-80f6-d0e92ba541a7', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('fddc5b7d-88f6-4bfb-acef-07e4b341e286', false, 'Interview 10 customers', '0cdf8d22-f45d-4a05-ae27-8e9e6621b560', 0);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('7ff4ddba-8c38-4f10-8bcc-0e065d2cf093', false, 'Review common customer pain points and suggestions', '0cdf8d22-f45d-4a05-ae27-8e9e6621b560', 1);
INSERT INTO subtasks (id, is_completed, title, task_id, position) VALUES ('f69522b1-1754-4fbd-9735-b975cbd716e0', false, 'Outline next steps for our roadmap', '0cdf8d22-f45d-4a05-ae27-8e9e6621b560', 2);


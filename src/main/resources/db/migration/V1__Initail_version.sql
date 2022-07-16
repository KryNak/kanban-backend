--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2 (Debian 14.2-1.pgdg110+1)
-- Dumped by pg_dump version 14.2 (Debian 14.2-1.pgdg110+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: boards; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.boards (
    id uuid NOT NULL,
    name character varying(255)
);


ALTER TABLE public.boards OWNER TO admin;

--
-- Name: boards_columns; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.boards_columns (
    boards_id uuid NOT NULL,
    columns_id uuid NOT NULL
);


ALTER TABLE public.boards_columns OWNER TO admin;

--
-- Name: columns; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.columns (
    id uuid NOT NULL,
    name character varying(255)
);


ALTER TABLE public.columns OWNER TO admin;

--
-- Name: columns_tasks; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.columns_tasks (
    columns_id uuid NOT NULL,
    tasks_id uuid NOT NULL
);


ALTER TABLE public.columns_tasks OWNER TO admin;

--
-- Name: subtasks; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.subtasks (
    id uuid NOT NULL,
    is_completed boolean NOT NULL,
    title character varying(255)
);


ALTER TABLE public.subtasks OWNER TO admin;

--
-- Name: tasks; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.tasks (
    id uuid NOT NULL,
    description character varying(255),
    status character varying(255),
    title character varying(255)
);


ALTER TABLE public.tasks OWNER TO admin;

--
-- Name: tasks_subtasks; Type: TABLE; Schema: public; Owner: admin
--

CREATE TABLE public.tasks_subtasks (
    tasks_id uuid NOT NULL,
    subtasks_id uuid NOT NULL
);


ALTER TABLE public.tasks_subtasks OWNER TO admin;

--
-- Data for Name: boards; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.boards (id, name) FROM stdin;
059d9f66-2d09-43b0-8aa7-64b160c366cd	Platform Launch
e6cc918f-11cd-4e54-b473-80dc27fa01fd	Marketing Plan
574fe61e-ec7a-4ab1-8d46-25f04925ca0c	Roadmap
\.


--
-- Data for Name: boards_columns; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.boards_columns (boards_id, columns_id) FROM stdin;
059d9f66-2d09-43b0-8aa7-64b160c366cd	c2340bf6-73ca-45a7-8125-7aae1b98cc5e
059d9f66-2d09-43b0-8aa7-64b160c366cd	2e371a65-57e1-48b9-bd0e-078a80cd1747
059d9f66-2d09-43b0-8aa7-64b160c366cd	467b1108-4110-4be2-954e-5f77f4fda7b2
e6cc918f-11cd-4e54-b473-80dc27fa01fd	7a9cea62-e8a4-41c6-be37-738f2ca74c29
e6cc918f-11cd-4e54-b473-80dc27fa01fd	41a1fbff-e5fd-4fe5-a755-d9c7ee101070
e6cc918f-11cd-4e54-b473-80dc27fa01fd	c338083a-d750-4682-9a74-39a18d0d760f
574fe61e-ec7a-4ab1-8d46-25f04925ca0c	84957417-dee0-4bbe-b19f-5148eaa7554f
574fe61e-ec7a-4ab1-8d46-25f04925ca0c	d997d466-b63c-4d9d-8574-79440af1e7ab
574fe61e-ec7a-4ab1-8d46-25f04925ca0c	0534de12-c6cd-4d05-b4d0-98d2016654e6
\.


--
-- Data for Name: columns; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.columns (id, name) FROM stdin;
c2340bf6-73ca-45a7-8125-7aae1b98cc5e	Doing
2e371a65-57e1-48b9-bd0e-078a80cd1747	Done
467b1108-4110-4be2-954e-5f77f4fda7b2	Todo
7a9cea62-e8a4-41c6-be37-738f2ca74c29	Doing
41a1fbff-e5fd-4fe5-a755-d9c7ee101070	Done
c338083a-d750-4682-9a74-39a18d0d760f	Todo
84957417-dee0-4bbe-b19f-5148eaa7554f	Next
d997d466-b63c-4d9d-8574-79440af1e7ab	Later
0534de12-c6cd-4d05-b4d0-98d2016654e6	Now
\.


--
-- Data for Name: columns_tasks; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.columns_tasks (columns_id, tasks_id) FROM stdin;
c2340bf6-73ca-45a7-8125-7aae1b98cc5e	698b275f-eaa0-43e0-8155-29a3fa7bcb67
c2340bf6-73ca-45a7-8125-7aae1b98cc5e	b48385e2-62e0-435c-b5ab-0fdfdfb004f0
c2340bf6-73ca-45a7-8125-7aae1b98cc5e	48a13e17-806c-428b-880d-76680088a210
c2340bf6-73ca-45a7-8125-7aae1b98cc5e	5fa71568-4ce6-48eb-b47d-6387dde95af5
c2340bf6-73ca-45a7-8125-7aae1b98cc5e	7eb6941b-43b7-4b96-aee3-87b862971a0e
c2340bf6-73ca-45a7-8125-7aae1b98cc5e	4ee31d1d-1128-497f-a647-9f907760ceda
2e371a65-57e1-48b9-bd0e-078a80cd1747	900a3fe5-d2f6-46a8-bdc0-d7008b0da63a
2e371a65-57e1-48b9-bd0e-078a80cd1747	c9cbaca5-9394-4714-8db2-d60de2199dc1
2e371a65-57e1-48b9-bd0e-078a80cd1747	f4e1305a-a335-44ae-8e2e-3a6239cf4e5a
2e371a65-57e1-48b9-bd0e-078a80cd1747	0949b2ad-61cf-40af-9682-a23df787fee4
2e371a65-57e1-48b9-bd0e-078a80cd1747	306b5d7d-73d4-4311-be21-48d8c7baf7bf
2e371a65-57e1-48b9-bd0e-078a80cd1747	0beed8ef-75a0-498d-9acf-a74115983b46
2e371a65-57e1-48b9-bd0e-078a80cd1747	fb91e39e-83c8-469e-ad4f-e24cc07dd96f
467b1108-4110-4be2-954e-5f77f4fda7b2	25d99d01-0426-4b6e-9523-190c59e7c9e5
467b1108-4110-4be2-954e-5f77f4fda7b2	42566a82-27df-4876-a600-b3399748d7e1
467b1108-4110-4be2-954e-5f77f4fda7b2	3113d557-a4db-44cb-a286-9cc43f15e864
467b1108-4110-4be2-954e-5f77f4fda7b2	3c53b129-7716-4536-9310-bdb1d5b0938f
c338083a-d750-4682-9a74-39a18d0d760f	b9fa6593-4e0b-493d-80b0-630010881bcd
c338083a-d750-4682-9a74-39a18d0d760f	87cb7e29-19d0-4f9f-9b91-9044079b04ed
c338083a-d750-4682-9a74-39a18d0d760f	409e52ee-7bf6-4433-b5d5-cd13d46a02a7
0534de12-c6cd-4d05-b4d0-98d2016654e6	9119560f-eac9-4bb6-adea-9bfbad19e81b
0534de12-c6cd-4d05-b4d0-98d2016654e6	e9a60587-62c9-42af-93b2-500664d40067
\.


--
-- Data for Name: subtasks; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.subtasks (id, is_completed, title) FROM stdin;
530c986b-f998-43e9-8906-161c76364347	f	Settings - Billing page
ce386362-e237-4f58-86d3-ffd10d2b5432	f	Search page
b38f2c2f-cfbe-41de-8716-6a22cef370b2	f	Settings - Account page
765bed8a-934d-43b4-a9d3-d9acee16286e	f	Upgrade plan
29451ffc-40aa-4d0d-a18f-08c9161455cd	f	Cancel plan
8dff88b1-436f-41ab-969c-89709dac4a8c	f	Update payment method
63ce4332-5ce4-42ec-8b92-cc5c3cec6db5	f	Talk to potential customers about our proposed solution and ask for fair price expectancy
e68ebb08-aa30-47c3-9905-9de9d18f9530	f	Outline a business model that works for our solution
54fec0f1-b78a-4ea8-8c7a-4b0bacace6a5	f	Research competitor pricing and business models
107f32ab-3551-4603-b974-3a19159419ee	f	Add search endpoint
8aeca48f-0efe-4a95-872b-8d7d53d1540b	f	Define search filters
16f3eb79-6858-4343-b0cc-8a84b707cc77	f	Welcome page
8a017f13-2be7-4d48-91e2-e277ae489303	f	Sign in page
d3536ae1-d103-46f2-a45c-6e138df532b7	f	Sign up page
956c4df1-5ccd-4591-9401-b195416ea1b1	f	Add auth endpoints
dbaa4d7d-2add-4f27-a8e2-016adc1370d4	f	Define user model
03ee4adb-1acb-4fb2-b9e2-8e69f706853a	f	Interview 10 prospective customers
d0a7785f-725d-4361-baa9-e8c2ce0920d2	f	Create clickable wireframe prototype in Balsamiq
3e9174a6-8da6-405b-ae15-7e4b198ae315	f	Find direct and indirect competitors
0a1c6009-63a6-40f8-80c1-7ae3b7e1299b	f	SWOT analysis for each competitor
81e140a1-de26-4688-9818-33facc5d4c78	f	Complete 5 wireframe prototype tests
13d82f9f-1250-4ffa-99f3-6af93d3c005f	f	Meet to review notes from previous tests and plan changes
9aabdae4-b8de-49c1-9cd3-4254362d7ef5	f	Conduct 5 usability tests
9c3f76fc-5030-481d-8f1a-c622e0968f8f	f	Make changes to paper prototypes
e4e2ed94-bd58-42cb-8a61-2cf34f4a2a80	f	Complete 10 usability tests
e874e8e5-ce2e-4dff-8fec-268eec4fa6ba	f	Create paper prototypes for version one
f034f55b-fe06-4dc3-a73a-7d40c1d3bdae	f	Write up research analysis
d9a8917c-ec09-4dbc-b3c2-e22cc27b1ae2	f	Calculate TAM
2ad1e4b6-c9eb-42db-b141-7752180244ca	f	Internal testing
1cc2d90d-ed70-40bb-aa46-8dfefe889c88	f	External testing
707e7fcf-dee6-44ae-bf42-a4757e2a69aa	f	Sign up page
20286917-3011-4abd-b427-f1de44de4b12	f	Welcome page
dc7de06e-455f-4edd-b23f-a282f8a9016b	f	Sign in page
faac53e2-c261-4283-ab0b-ebe9169bdcb0	f	Search page
6a80d787-6021-46fb-b2c3-fd9b2a57a810	f	Account page
0e341e76-b312-4803-b795-ebbfc197bee8	f	Billing page
be1f3c70-f052-4994-8f16-ca10f69f35af	f	Draft out HN post
16153cff-7aa6-4669-a9c7-f5bbaac6693c	f	Publish post
707343d2-6b3e-4cbc-8608-3a6127af08db	f	Get feedback and refine
5f46825b-d98f-4af7-b400-749038e0a8b8	f	Notify customers
6caae0ab-3c57-4a0a-be9d-e13054582a09	f	Launch!
a05c1532-7bfb-46f3-8d6f-f163947c83ea	f	Draft product page
2adc86a5-1020-4ba2-97cc-640cb12f9921	f	Notify network
e6aff08c-3e61-4807-9763-e2b4aa18bbc6	f	Find hunter
35895129-8dfb-47b2-8a82-2ae67f7085ea	f	Gather assets
e80d19b3-3cde-47f4-86ac-222f2b6fcfae	f	Publish on Medium
17ac5533-379b-48a9-8281-310eb9b45be1	f	Write article
79143a51-d27b-4213-950f-196b55aeb482	f	Publish on LinkedIn
0ae6e49d-c782-49d8-b378-134963699f17	f	Publish on Inndie Hackers
5047bcc8-b385-47bc-ba0c-0183daeb92b2	f	Review common customer pain points and suggestions
e7576bb4-e834-4522-b6ca-d59731ace0b8	f	Outline next steps for our roadmap
28f1f362-c30f-4211-b7bb-628441a4411e	f	Interview 10 customers
843ed883-58c2-45e5-a96f-b3bb12ee9244	f	Launch publicly on PH, HN, etc.
f52d0582-1cff-4a66-ba5e-3d6f41f11152	f	Launch privately to our waitlist
\.


--
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.tasks (id, description, status, title) FROM stdin;
698b275f-eaa0-43e0-8155-29a3fa7bcb67		Doing	Design settings and search pages
b48385e2-62e0-435c-b5ab-0fdfdfb004f0		Doing	Add account management endpoints
48a13e17-806c-428b-880d-76680088a210	We know what we're planning to build for version one. Now we need to finalise the first pricing model we'll use. Keep iterating the subtasks until we have a coherent proposition.	Doing	Research pricing points of various competitors and trial different business models
5fa71568-4ce6-48eb-b47d-6387dde95af5		Doing	Add search enpoints
7eb6941b-43b7-4b96-aee3-87b862971a0e		Doing	Design onboarding flow
4ee31d1d-1128-497f-a647-9f907760ceda		Doing	Add authentication endpoints
900a3fe5-d2f6-46a8-bdc0-d7008b0da63a	We need to define and refine our core product. Interviews will help us learn common pain points and help us define the strongest MVP.	Done	Market discovery
c9cbaca5-9394-4714-8db2-d60de2199dc1	Create a greyscale clickable wireframe prototype to test our asssumptions so far.	Done	Create wireframe prototype
f4e1305a-a335-44ae-8e2e-3a6239cf4e5a		Done	Competitor analysis
0949b2ad-61cf-40af-9682-a23df787fee4	Ensure the layout continues to make sense and we have strong buy-in from potential users.	Done	Conduct 5 wireframe tests
306b5d7d-73d4-4311-be21-48d8c7baf7bf	Keep iterating through the subtasks until we're clear on the core concepts for the app.	Done	Review results of usability tests and iterate
0beed8ef-75a0-498d-9acf-a74115983b46		Done	Create paper prototypes and conduct 10 usability tests with potential customers
fb91e39e-83c8-469e-ad4f-e24cc07dd96f	We need to get a solid overview of the market to ensure we have up-to-date estimates of market size and demand.	Done	Research the market
25d99d01-0426-4b6e-9523-190c59e7c9e5	Once we feel version one is ready, we need to rigorously test it both internally and externally to identify any major gaps.	Todo	QA and test all major user journeys
42566a82-27df-4876-a600-b3399748d7e1		Todo	Build UI for onboarding flow
3113d557-a4db-44cb-a286-9cc43f15e864		Todo	Build UI for search
3c53b129-7716-4536-9310-bdb1d5b0938f		Todo	Build settings UI
b9fa6593-4e0b-493d-80b0-630010881bcd			Share on Show HN
87cb7e29-19d0-4f9f-9b91-9044079b04ed		Todo	Plan Product Hunt launch
409e52ee-7bf6-4433-b5d5-cd13d46a02a7			Write launch article to publish on multiple channels
9119560f-eac9-4bb6-adea-9bfbad19e81b	Beyond the initial launch, we're keeping the initial roadmap completely empty. This meeting will help us plan out our next steps based on actual customer feedback.		Review early feedback and plan next steps for roadmap
e9a60587-62c9-42af-93b2-500664d40067			Launch version one
\.


--
-- Data for Name: tasks_subtasks; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.tasks_subtasks (tasks_id, subtasks_id) FROM stdin;
698b275f-eaa0-43e0-8155-29a3fa7bcb67	530c986b-f998-43e9-8906-161c76364347
698b275f-eaa0-43e0-8155-29a3fa7bcb67	ce386362-e237-4f58-86d3-ffd10d2b5432
698b275f-eaa0-43e0-8155-29a3fa7bcb67	b38f2c2f-cfbe-41de-8716-6a22cef370b2
b48385e2-62e0-435c-b5ab-0fdfdfb004f0	765bed8a-934d-43b4-a9d3-d9acee16286e
b48385e2-62e0-435c-b5ab-0fdfdfb004f0	29451ffc-40aa-4d0d-a18f-08c9161455cd
b48385e2-62e0-435c-b5ab-0fdfdfb004f0	8dff88b1-436f-41ab-969c-89709dac4a8c
48a13e17-806c-428b-880d-76680088a210	63ce4332-5ce4-42ec-8b92-cc5c3cec6db5
48a13e17-806c-428b-880d-76680088a210	e68ebb08-aa30-47c3-9905-9de9d18f9530
48a13e17-806c-428b-880d-76680088a210	54fec0f1-b78a-4ea8-8c7a-4b0bacace6a5
5fa71568-4ce6-48eb-b47d-6387dde95af5	107f32ab-3551-4603-b974-3a19159419ee
5fa71568-4ce6-48eb-b47d-6387dde95af5	8aeca48f-0efe-4a95-872b-8d7d53d1540b
7eb6941b-43b7-4b96-aee3-87b862971a0e	16f3eb79-6858-4343-b0cc-8a84b707cc77
7eb6941b-43b7-4b96-aee3-87b862971a0e	8a017f13-2be7-4d48-91e2-e277ae489303
7eb6941b-43b7-4b96-aee3-87b862971a0e	d3536ae1-d103-46f2-a45c-6e138df532b7
4ee31d1d-1128-497f-a647-9f907760ceda	956c4df1-5ccd-4591-9401-b195416ea1b1
4ee31d1d-1128-497f-a647-9f907760ceda	dbaa4d7d-2add-4f27-a8e2-016adc1370d4
900a3fe5-d2f6-46a8-bdc0-d7008b0da63a	03ee4adb-1acb-4fb2-b9e2-8e69f706853a
c9cbaca5-9394-4714-8db2-d60de2199dc1	d0a7785f-725d-4361-baa9-e8c2ce0920d2
f4e1305a-a335-44ae-8e2e-3a6239cf4e5a	3e9174a6-8da6-405b-ae15-7e4b198ae315
f4e1305a-a335-44ae-8e2e-3a6239cf4e5a	0a1c6009-63a6-40f8-80c1-7ae3b7e1299b
0949b2ad-61cf-40af-9682-a23df787fee4	81e140a1-de26-4688-9818-33facc5d4c78
306b5d7d-73d4-4311-be21-48d8c7baf7bf	13d82f9f-1250-4ffa-99f3-6af93d3c005f
306b5d7d-73d4-4311-be21-48d8c7baf7bf	9aabdae4-b8de-49c1-9cd3-4254362d7ef5
306b5d7d-73d4-4311-be21-48d8c7baf7bf	9c3f76fc-5030-481d-8f1a-c622e0968f8f
0beed8ef-75a0-498d-9acf-a74115983b46	e4e2ed94-bd58-42cb-8a61-2cf34f4a2a80
0beed8ef-75a0-498d-9acf-a74115983b46	e874e8e5-ce2e-4dff-8fec-268eec4fa6ba
fb91e39e-83c8-469e-ad4f-e24cc07dd96f	f034f55b-fe06-4dc3-a73a-7d40c1d3bdae
fb91e39e-83c8-469e-ad4f-e24cc07dd96f	d9a8917c-ec09-4dbc-b3c2-e22cc27b1ae2
25d99d01-0426-4b6e-9523-190c59e7c9e5	2ad1e4b6-c9eb-42db-b141-7752180244ca
25d99d01-0426-4b6e-9523-190c59e7c9e5	1cc2d90d-ed70-40bb-aa46-8dfefe889c88
42566a82-27df-4876-a600-b3399748d7e1	707e7fcf-dee6-44ae-bf42-a4757e2a69aa
42566a82-27df-4876-a600-b3399748d7e1	20286917-3011-4abd-b427-f1de44de4b12
42566a82-27df-4876-a600-b3399748d7e1	dc7de06e-455f-4edd-b23f-a282f8a9016b
3113d557-a4db-44cb-a286-9cc43f15e864	faac53e2-c261-4283-ab0b-ebe9169bdcb0
3c53b129-7716-4536-9310-bdb1d5b0938f	6a80d787-6021-46fb-b2c3-fd9b2a57a810
3c53b129-7716-4536-9310-bdb1d5b0938f	0e341e76-b312-4803-b795-ebbfc197bee8
b9fa6593-4e0b-493d-80b0-630010881bcd	be1f3c70-f052-4994-8f16-ca10f69f35af
b9fa6593-4e0b-493d-80b0-630010881bcd	16153cff-7aa6-4669-a9c7-f5bbaac6693c
b9fa6593-4e0b-493d-80b0-630010881bcd	707343d2-6b3e-4cbc-8608-3a6127af08db
87cb7e29-19d0-4f9f-9b91-9044079b04ed	5f46825b-d98f-4af7-b400-749038e0a8b8
87cb7e29-19d0-4f9f-9b91-9044079b04ed	6caae0ab-3c57-4a0a-be9d-e13054582a09
87cb7e29-19d0-4f9f-9b91-9044079b04ed	a05c1532-7bfb-46f3-8d6f-f163947c83ea
87cb7e29-19d0-4f9f-9b91-9044079b04ed	2adc86a5-1020-4ba2-97cc-640cb12f9921
87cb7e29-19d0-4f9f-9b91-9044079b04ed	e6aff08c-3e61-4807-9763-e2b4aa18bbc6
87cb7e29-19d0-4f9f-9b91-9044079b04ed	35895129-8dfb-47b2-8a82-2ae67f7085ea
409e52ee-7bf6-4433-b5d5-cd13d46a02a7	e80d19b3-3cde-47f4-86ac-222f2b6fcfae
409e52ee-7bf6-4433-b5d5-cd13d46a02a7	17ac5533-379b-48a9-8281-310eb9b45be1
409e52ee-7bf6-4433-b5d5-cd13d46a02a7	79143a51-d27b-4213-950f-196b55aeb482
409e52ee-7bf6-4433-b5d5-cd13d46a02a7	0ae6e49d-c782-49d8-b378-134963699f17
9119560f-eac9-4bb6-adea-9bfbad19e81b	5047bcc8-b385-47bc-ba0c-0183daeb92b2
9119560f-eac9-4bb6-adea-9bfbad19e81b	e7576bb4-e834-4522-b6ca-d59731ace0b8
9119560f-eac9-4bb6-adea-9bfbad19e81b	28f1f362-c30f-4211-b7bb-628441a4411e
e9a60587-62c9-42af-93b2-500664d40067	843ed883-58c2-45e5-a96f-b3bb12ee9244
e9a60587-62c9-42af-93b2-500664d40067	f52d0582-1cff-4a66-ba5e-3d6f41f11152
\.


--
-- Name: boards_columns boards_columns_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.boards_columns
    ADD CONSTRAINT boards_columns_pkey PRIMARY KEY (boards_id, columns_id);


--
-- Name: boards boards_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.boards
    ADD CONSTRAINT boards_pkey PRIMARY KEY (id);


--
-- Name: columns columns_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.columns
    ADD CONSTRAINT columns_pkey PRIMARY KEY (id);


--
-- Name: columns_tasks columns_tasks_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.columns_tasks
    ADD CONSTRAINT columns_tasks_pkey PRIMARY KEY (columns_id, tasks_id);


--
-- Name: subtasks subtasks_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.subtasks
    ADD CONSTRAINT subtasks_pkey PRIMARY KEY (id);


--
-- Name: tasks tasks_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);


--
-- Name: tasks_subtasks tasks_subtasks_pkey; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.tasks_subtasks
    ADD CONSTRAINT tasks_subtasks_pkey PRIMARY KEY (tasks_id, subtasks_id);


--
-- Name: boards_columns uk_9e9v4l8bumggwyonvap1nm70h; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.boards_columns
    ADD CONSTRAINT uk_9e9v4l8bumggwyonvap1nm70h UNIQUE (columns_id);


--
-- Name: columns_tasks uk_a6ed2m11pf5ntafb63vrcgwa6; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.columns_tasks
    ADD CONSTRAINT uk_a6ed2m11pf5ntafb63vrcgwa6 UNIQUE (tasks_id);


--
-- Name: tasks_subtasks uk_q33nhake2rv0iq5whd258i7u6; Type: CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.tasks_subtasks
    ADD CONSTRAINT uk_q33nhake2rv0iq5whd258i7u6 UNIQUE (subtasks_id);


--
-- Name: boards_columns fk4h2iagtfhash47p7iue3esdvq; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.boards_columns
    ADD CONSTRAINT fk4h2iagtfhash47p7iue3esdvq FOREIGN KEY (columns_id) REFERENCES public.columns(id);


--
-- Name: columns_tasks fk4mt217k4worxb6eqn8jn9f6q7; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.columns_tasks
    ADD CONSTRAINT fk4mt217k4worxb6eqn8jn9f6q7 FOREIGN KEY (tasks_id) REFERENCES public.tasks(id);


--
-- Name: tasks_subtasks fkcbmy2op2pi4fd981b129049ky; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.tasks_subtasks
    ADD CONSTRAINT fkcbmy2op2pi4fd981b129049ky FOREIGN KEY (tasks_id) REFERENCES public.tasks(id);


--
-- Name: columns_tasks fkg9vkf0rsww7s0uq83qn5tys58; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.columns_tasks
    ADD CONSTRAINT fkg9vkf0rsww7s0uq83qn5tys58 FOREIGN KEY (columns_id) REFERENCES public.columns(id);


--
-- Name: tasks_subtasks fkiws1ife9fv2tyse8ylljcjj4v; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.tasks_subtasks
    ADD CONSTRAINT fkiws1ife9fv2tyse8ylljcjj4v FOREIGN KEY (subtasks_id) REFERENCES public.subtasks(id);


--
-- Name: boards_columns fkpix8tub68pqapy091hdfraqht; Type: FK CONSTRAINT; Schema: public; Owner: admin
--

ALTER TABLE ONLY public.boards_columns
    ADD CONSTRAINT fkpix8tub68pqapy091hdfraqht FOREIGN KEY (boards_id) REFERENCES public.boards(id);


--
-- PostgreSQL database dump complete
--


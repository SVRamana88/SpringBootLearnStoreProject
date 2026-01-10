-- SELECT conname
-- FROM pg_constraint
-- WHERE conrelid = 'profiles'::regclass;


--Drop the wrong foreign key constraint
ALTER TABLE profiles
DROP
CONSTRAINT profiles_id_fkey;

--Add the correct column
ALTER TABLE profiles
    ADD COLUMN user_id INT;

--add the correct foreign key contarint
ALTER TABLE profiles
    ADD CONSTRAINT profiles_user_id_fkey
        FOREIGN KEY (user_id) REFERENCES users (id)
            ON DELETE CASCADE;







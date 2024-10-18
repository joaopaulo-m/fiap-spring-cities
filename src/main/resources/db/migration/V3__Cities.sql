DECLARE
    table_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO table_count FROM user_tables WHERE table_name = 'WATERSTATUSCITIES';

    IF table_count = 0 THEN
        EXECUTE IMMEDIATE 'CREATE SEQUENCE water_status_cities_seq
                           START WITH 1
                           INCREMENT BY 1;


                           CREATE TABLE WATERSTATUSCITIES (
                               id NUMBER PRIMARY KEY,
                               status VARCHAR2(50),
                               msg VARCHAR2(100),
                               date_updated TIMESTAMP,
                               city VARCHAR2(100)
                           );

                           CREATE SEQUENCE water_status_cities_seq
                           START WITH 1
                           INCREMENT BY 1;

                           CREATE OR REPLACE TRIGGER water_status_cities_trigger
                           BEFORE INSERT ON WATERSTATUSCITIES
                           FOR EACH ROW
                           BEGIN
                               SELECT water_status_cities_seq.NEXTVAL
                               INTO :NEW.id
                               FROM dual;
                           END;';
    END IF;
END;




## How to run

### BackEnd

* At root directory of the backend, run ` mvn clean install` to install the dependencies.
* Modify `application.properties` file located in the `src/main/resources directory` with your database connection details.
* Once the dependencies have been installed, you can run the backend application.
* in your database create two data for the `store` table, if you are using SQL table, you can use ` INSERT INTO store (name, address, phone_number) VALUES
('Store 1', 'Izola', '123456789'),
('Store 2', 'Piran', '987654321');`

### FrontEnd

* At root directory of the frontend, run `npm install` to install the dependencies.
* Once the dependencies have been installed, run the Angular application by `ng serve`.
* Open (http://localhost:4200/) to view it in the browser.

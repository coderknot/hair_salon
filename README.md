# Administrateur de Salon

#### _A web application providing a management dashboard for a hair salon, Current Version: 03-31-2017_

#### By _**John Carr**_

## Description
This salon management software allows an adminstrator to add stylists and clients into the system. Clients can be added to a stylist or reassigned to another stylist. Stylist and client details may be updated. Both stylists and clients can be removed from the system. Clients must be reassigned to another stylist before an individual stylist can be removed.

## Setup/Installation Requirements
* Clone portfolio respository from: <http://github.com/coderknot/hair-salon>
* In terminal run:
  * <code>psql hair_salon < hair_salon.sql</code> to restore database schema
  * <code>postgres</code> to begin postgres process
  * <code>gradle run</code> to compile and run application
* In a browser, navigate to localhost:4567

## Specifications

| Behavior                   | Input Example     | Output Example    |
| -------------------------- | -----------------:| -----------------:|
| The program should create systlists in the system | (no stylists) | Stylist |
| The program should create clients in the system | (no clients) | Client |
| The pogram should assign a stylist to a client upon client creation | Stylist ID: 1 (Stylist) | Stylist ID: 1 (Client) |
| The program should update a stylist's details | Stylist Name: Chriss (system) Stylist Name: Chris (update) | Stylist Name: Chris (system)|
| The program should update a client's details | Client Email: test88@test.com (system) Client Email: test87@test.com (update) | Client Email: test87@test.com (system)|
| The program should delete a client from the system | Stylist (delete) | (no stylist) |
| The program should delete a stylist from the system | Client (delete) | (no client) |

## Technologies Used
* _JAVA_
* _JUnit_
* _Gradle_
* _Spark Framework_
* _Velocity Template Engine_
* _HTML_
* _Bootstrap_
* _CSS_

## Support and contact details
Questions? Concerns? Suggestions?

Reach out to me via github:
<http://github.com/coderknot>

## License

MIT License

Copyright (c) 2017 John Carr

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

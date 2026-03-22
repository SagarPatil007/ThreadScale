This Project demonstrates the response time improvement when we compare a traditional blocking sprinboot project to a non-blocking springboot project.
We achieved major performance gains: read operations became noticeably faster, CRUD workflows improved by 95.6%, and file read/write processing efficiency increased by 85%.
1. Blocking (Synchronous) Microservices
Blocking APIs stop the execution thread until a result is received from the backend layer.
1. Non-Blocking (Asynchronous) Microservices
Non-blocking APIs don’t wait for the backend response. They continue handling new incoming user requests.
2. Blocking (Synchronous) Microservices
A single thread serves the entire request from controller → business layer → repository layer.
This same thread is blocked until the response is returned.
2. Non-Blocking (Asynchronous) Microservices
Multiple worker threads perform backend tasks.
The main thread passes the request to a worker thread from a pool and continues serving new requests.
The worker thread processes the request and sends the response back to the user.

Note: We can also create non-blocking APIs in Spring Boot using async features and CompletableFuture.
<img width="1466" height="709" alt="Screenshot 2025-11-15 at 9 09 50 AM" src="https://github.com/user-attachments/assets/0ec7525e-cb35-42a8-9350-d2581c134ad7" />
<img width="1466" height="709" alt="Screenshot 2025-11-15 at 9 10 21 AM" src="https://github.com/user-attachments/assets/78833a6e-7eee-4a68-9c6d-1a0691946f02" />
<img width="1466" height="724" alt="Screenshot 2025-11-15 at 9 10 33 AM" src="https://github.com/user-attachments/assets/6e3a2d4c-0f3e-40be-839b-01f8f382d471" />

API Response Time Diff

<img width="1203" height="540" alt="Screenshot 2025-11-15 at 9 16 17 AM" src="https://github.com/SagarPatil007/ThreadScale/blob/main/screenshots/1.png" />

<img width="1183" height="521" alt="Screenshot 2025-11-15 at 9 16 44 AM" src="https://github.com/SagarPatil007/ThreadScale/blob/main/screenshots/2.png" />

<img width="1226" height="498" alt="Screenshot 2025-11-15 at 9 16 56 AM" src="https://github.com/SagarPatil007/ThreadScale/blob/main/screenshots/3.png" />
<img width="1193" height="487" alt="Screenshot 2025-11-15 at 9 17 11 AM" src="https://github.com/SagarPatil007/ThreadScale/blob/main/screenshots/4.png" />

<img width="1189" height="383" alt="Screenshot 2025-11-15 at 9 20 13 AM" src="https://github.com/SagarPatil007/ThreadScale/blob/main/screenshots/5.png" />
<img width="1210" height="489" alt="Screenshot 2025-11-15 at 9 20 31 AM" src="https://github.com/SagarPatil007/ThreadScale/blob/main/screenshots/6.png" />

<img width="1182" height="449" alt="Screenshot 2025-11-15 at 9 20 57 AM" src="https://github.com/SagarPatil007/ThreadScale/blob/main/screenshots/7.png" />
<img width="1181" height="444" alt="Screenshot 2025-11-15 at 9 26 36 AM" src="https://github.com/SagarPatil007/ThreadScale/blob/main/screenshots/8.png" />

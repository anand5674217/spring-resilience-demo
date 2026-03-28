# Spring Resilience Demo

This project demonstrates fault tolerance in microservices using:

- Circuit Breaker (Resilience4j)
- Retry mechanism
- Fallback handling
- Actuator monitoring

## Services
- user-service (caller)
- order-service (downstream)

## Key Concepts
- CLOSED → OPEN → HALF_OPEN state transitions
- Failure rate threshold handling
- Prevention of cascading failures

## Architecture

Client → User Service → Order Service  
           ↓
        Eureka Server (service discovery)

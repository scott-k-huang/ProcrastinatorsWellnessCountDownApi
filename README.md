# ProcrastinatorsWellnessCountDownApi
API For Procrastinator's Wellness Countdown API application

## Intellij Run Profile Instructions
the following instructions allow for running the API within Intellij

### Dockerfile 
The following configurations must be set:
1. Under the "Run" heading the Bind Ports must be set otherwise access won't be granted.  For insecure, I just do 8080:8080
2. Under the "Run" heading the environment variable SPRING_PROFILES_ACTIVE needs to be added and set to desired profile (e.g. SPRING_PROFILES_ACTIVE=prod)
2. Under the "Before Launch" heading you need to add indicate the "clean" and "package" maven goals need to be run prior to launch
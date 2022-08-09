# app archs

## monolithic arch
back when the internet was just starting to gain popularity websites used to serve mostly static content. therre wasnt a lot of user interaction like we see now. the apps were much less complex and so was their arch. a single app used to take care of the entire user journey everything from ui rendering to backend business logic to fetching the data from dbs or file systems. this was the world of web 1.0

then came web 2.0 w social netowrks, e commerce n online gaming n things became a lot of interactive. by this time everything was still maintained in a single huge codebase. if u consider an ecommerce system back then everything from ui to business logic for payments carts orders etc was maintained in a single codebased . this is known as **monolithic architecture**

![image](https://leetcode.com/explore/featured/card/Figures/System_Design/Chapter_2/Microservices_1.png)

the problem w this approach was that the code was very complex difficult to maintain and hard to iterate n improve. on top of that multiple people were working on the same codebase - it was a recipe for disaster

to solve this we started using more efficient design patterns various OOPS concepts to streamline the code and tried to make it more modular. for this we broke down the code into various modules which took care of a specific feature group. so all the payment related stuff was handled by a payments module cart related features were taken care of by a Cart module orders related code in an Order module, if there was any shared code we moved it out to a shared module n so on. now instead of everyone working on the same code each team could work on the module meant for their own features. this is how the modern day monoliths are built

![image](https://leetcode.com/explore/featured/card/Figures/System_Design/Chapter_2/Microservices_2.png)

## what are the downsides?
as the team size grows some problems start coming up with this approach as well
- one of the most common problems w monoliths is that u r Bound 2 a single technology stack. suppose u have a monolith built on java w spring framework. now u need to add some machine learning logic n u want to use python for it. that is nearly impossible in monolithic architecture. u either need to figure out a way to do this w java or u need a standalone app that handles ur machine learning logic which defeats the purpose of a monolithic app
- another problem would be that it is very easy to break thing s in such an arch. that is because when u have such a huge codebase it is nearly impossible for everyone to know everything about how the entire system works. if u change some logic in the shared code u might end up breaking someone else's feature. sure u can have test cases but even those r not enough sometimes
- another major issue is scalability. it is very tricky to scale a monolithic application. let us look at the example of an ecommerce app. in case of a black friday sale u might need to scale ur payments n cart modules but warehouse n notification modules can continue to work at the same pace. this cannot b done in a monolithic app. since it is the same codebase u will need to deploy the entire system again n again. this means the capacity for the Warehouse module might b sittiing idle or that the Payment and Cart modules may choke the rest of the system
- deployments r also a very tedious process here. since the code is huge it takes much longer ot build package n deploy the code. that said if u update the code for warehousing even the payments module must b redployed since everything is packaged together
- if there is a performance issue in one part of the system chances r it will leak to the rest of the system as well. even a small memory leak in the Warehousing module if it starts choking the other modules can cause the entire app to have issues
so whats the solution for this?

## microservice architecture
![image](https://leetcode.com/explore/featured/card/Figures/System_Design/Chapter_2/Microservices_3.png)

the idea is to break down the app into logical components such that these components become services of their own. meaning they have the code for that part of the user's journey and the data, basically that this service is now the primary source of truth for that particular feature group. normally this is also how teams would b structured so each team would work on the services that handle their features. these services will now b communicating with each other via a set of API calls like REST API's or remote procedure calls

## benefits of microservice architecture
- we 

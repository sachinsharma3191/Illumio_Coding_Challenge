# Illumio Coding Challenge

## Description

Firewall.java Contains the Application Logic for creating firewall rules and testing of packets in firewall 

Port.java POJO class for storing Port Information

NetworkRule.java Pojo Class for storing Firewall Rules (Protocol, Inbound, IP Port, IP Address)

IPAddress.java Pojo class for storing IP Address Range

FirewallTest.java  JUnit Test case

## Build/Run/Test Application
Maven is required to build an application. Clone or Download the repo. Go to cmd or command line in the application
Now issue the following command to build project 
mvn clean install 

It will download the necessary jars. 

Run FirewallTest.java to test the applications

## Design Choices
I  have used the Hashing Data Structure(HashSet of Collections Framework) to store and retrieve the network rules. Hashing provides faster add, retrieval, and remove operations.
The time complexity for all operations is O(1), which is faster for the larger dataset.

I have utilized FileChannel of java.nio package for reading large datasets in the CSV file. This will work on the larger dataset(500-100 Million).
I have benchmarked FileChannel for 1.5-1.9 records. The total execution time is 7-12 seconds.95 % of execution time is spent on storing the network rules in HashSet.

## Optimization/Improvements
Although Hashing provides O(1) time complexity for all operations.Hashing collisions are avoidable on a large dataset. Use of Trees(Balanced Search Trees, AVL Trees) can help mitigate the issue. Time Complexity for trees operations is O(log n). So the combination of Hashing/Tree is a further improvement over the current solution.
 
Multithreading could be utilized to achieve concurrency/parallelism. 

Caching can be utilized to boost peformance

## Team Interest
Data Team

Platform Team

Policy Team

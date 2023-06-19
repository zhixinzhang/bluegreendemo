# bluegreendemo


# This is Blizzard home workd demo. 
Technical sets:
1. Java (Spring boot framework)
2. Javascript
3. AWS (ECS, ALB)
4. Docker



# Docker Command Line
1. docker pull zhangzhixinluke/blizzardbluegreendemo:latest


# AWS
1. Create IAM User (Admin) 
2. Set Access Key
3. Set AWS Configure
```
lukezhang@DESKTOP-7687KRD:~$ aws configure
AWS Access Key ID [None]: AKIATM************LU2
AWS Secret Access Key [None]: 9lDeKVK*******EtwStk
Default region name [None]: us-west-2
Default output format [None]:
```
4. AWS check ecs
```
lukezhang@DESKTOP-7687KRD:~$ aws ecs list-clusters
{
    "clusterArns": [
        "arn:aws:ecs:us-west-2:234049477522:cluster/ECS-Prod-Cluster-Blizzard"
    ]
}
```

5. AWS create ecs service with codedeploy
```
aws ecs create-service --cli-input-json file://~/projects/bluegreendemo/src/main/resources/config/create-ecs-service.json
```
output
```
lukezhang@DESKTOP-7687KRD:~/projects$ aws ecs create-service --cli-input-json file://~/projects/bluegreendemo/src/main/r
esources/config/create-ecs-service.json
{
    "service": {
        "serviceArn": "arn:aws:ecs:us-west-2:234049477522:service/ECS-Prod-Cluster-Blizzard/ECS-Prod-Cluster-Blizzard-Service",
        "serviceName": "ECS-Prod-Cluster-Blizzard-Service",
        "clusterArn": "arn:aws:ecs:us-west-2:234049477522:cluster/ECS-Prod-Cluster-Blizzard",
        "loadBalancers": [
:...skipping...
```
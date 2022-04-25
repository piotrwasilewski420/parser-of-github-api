My email in recruitment process: `piotr.wasilewski420@gmail.com`

# Github Repo Reader Summer Experience Allegro 2022

* * *

### Overview

Github Repo Reader is a back-end application written in Java that thanks to Github API enables an easy access to the data about user (login,name,bio) and info about his repositories (language,bytes of code).

* * *

### Notable Issues

##### Github API

Due to Github API's rate limitations concerning the amount of times an unathenticated user can request data from the server there were some assumptions that had to be made. User that is not authenticated can access data from the API only 60 times per hour. That amount of requests wouldn't be enough to read data for a larger number of repositories. In my application every request to the Github API contains an authorization header that contains both a valid github username and verification token stored in a Java class Credentials.java. **This solution is used only for simplicity sakes and would not be allowed in real business/production scenario because it is a serious security threat.** To fully secure this kind of permament credentials they should be kept in a [Vault](https://spring.io/projects/spring-vault) or other auth protocols such as [OAUth2](https://oauth.net/2/) are to be used. With the current approach a 5000 requests can be made from one IP adress within an hour.

##### Repos with no detectable languages

If a language used in a repo is not listed in [here](https://github.com/github/linguist/tree/master/samples) that means that languages array will be shown as "null". The same issue may happen to the repositories that are empty.

* * *

### Core Technologies

1.  Java 17
2.  Spring Boot 5
3.  WebClient
4.  Github API

* * *

### Installation

1. In order to test the application you need to ensure that docker is locally installed on your machine. Run `docker -v` to find it out.
2. Once you are sure docker is installed clone repository `git clone https://github.com/piotrwasilewski420/allegro-summer-experience-2022.git` and go to the project folder and run the following command
to build the image `docker build --tag=piotrwasilewski420/allegro-summer-experience-2022 . ` alternatively run `docker pull piotrwasilewski420/allegro-summer-experience-2022` to pull the docker image from the repository.
3. Last step is to run `docker run -p $PORT:8080 piotrwasilewski420/allegro-summer-experience-2022` to run the app as a container. You have to substitute $PORT with a port number that is not occupied on your local machine. For example if you want this app to run on your local port 8080 run                                        `docker run -p 8080:8080 piotrwasilewski420/allegro-summer-experience-2022` in your console/terminal.

* * *

### Endpoints

Three endpoints are available to make API calls.

1.     /api/{username}

2.     /api/{username}/repos

3.     /api/rate_limit

Sample API call for the container running on port 8080:  `http://localhost:8080/api/bartlomiejmont/repos`

Result: 

``` { "repository_name": "ExploreEnglish", "languages": [ { "language_name": "C#", "bytes": 142122 }, { "language_name": "ShaderLab", "bytes": 112831 }, { "language_name": "HLSL", "bytes": 2286 } ] }, { "repository_name": "GenerowaniePodzbiorow", "languages": [ { "language_name": "Java", "bytes": 2652 } ] }, ```

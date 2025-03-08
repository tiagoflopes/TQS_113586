This exercise focuses on using a Docker browser webdriver.
The test is the same as the one I wrote for the first exercise.
I had problems with the docker daemon.json not exposing the Docker API.
I added this line _"hosts": ["unix:///var/run/docker.sock", "tcp://0.0.0.0:2375"]_ to fix the problem.
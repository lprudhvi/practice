def newgit(repo)
{
  git"${repo}"
}
def maven()
{
  sh 'mvn package'
}
def deploy(ip,appname)
{
  deploy adapters: [tomcat9(credentialsId: '6d73c005-a16e-4384-8ab4-079cade2bf05', path: '', url: "${ip}")], contextPath: "${appname}", war: '**/*.war'
}
def test(jobname)
{
  sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}

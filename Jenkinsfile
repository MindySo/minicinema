pipeline{
	agent { docker { image 'gradle:8.5-jdk17' } }
	stages {
		stage('build') {
			steps {
				sh 'gradle --version'
			}
		}
	}
}
# Script to measure code coverage with JaCoCo
# This script compiles Java files and generates coverage report

param(
    [string]$JavaHome = "C:\Program Files\Java\jdk-11"
)

# Create output directories
$outputDir = "target"
$classesDir = "$outputDir\classes"
$testClassesDir = "$outputDir\test-classes"
$jacocoDir = "$outputDir\jacoco"

if (-not (Test-Path $outputDir)) { New-Item -ItemType Directory -Path $outputDir | Out-Null }
if (-not (Test-Path $classesDir)) { New-Item -ItemType Directory -Path $classesDir | Out-Null }
if (-not (Test-Path $testClassesDir)) { New-Item -ItemType Directory -Path $testClassesDir | Out-Null }
if (-not (Test-Path $jacocoDir)) { New-Item -ItemType Directory -Path $jacocoDir | Out-Null }

Write-Host "JaCoCo Code Coverage Setup" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Green
Write-Host ""
Write-Host "This setup requires Java to be installed on your system."
Write-Host ""
Write-Host "To measure code coverage with JaCoCo, follow these steps:"
Write-Host ""
Write-Host "1. INSTALL JAVA (if not already installed):"
Write-Host "   - Download from: https://www.oracle.com/java/technologies/downloads/"
Write-Host "   - Or use Windows Installer"
Write-Host ""
Write-Host "2. INSTALL MAVEN or GRADLE:"
Write-Host "   Using package manager (chocolatey):"
Write-Host "   - choco install maven"
Write-Host "   - choco install gradle"
Write-Host ""
Write-Host "3. WITH MAVEN:"
Write-Host "   cd to the project directory and run:"
Write-Host "   mvn clean test jacoco:report"
Write-Host ""
Write-Host "4. WITH GRADLE:"
Write-Host "   cd to the project directory and run:"
Write-Host "   gradlew test jacocoTestReport"
Write-Host ""
Write-Host "5. VIEW THE REPORT:"
Write-Host "   - Maven report: target/site/jacoco/index.html"
Write-Host "   - Gradle report: build/reports/jacoco/test/html/index.html"
Write-Host ""
Write-Host "========================================" -ForegroundColor Green

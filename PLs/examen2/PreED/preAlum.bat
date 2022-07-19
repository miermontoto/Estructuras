@echo Borrando Papelera
recycle /E:C

REM @echo Borrando Escritorio
REM @for /D %%p in (%systemdrive%\users\alumno\desktop\*.*)  do rd /S /Q "%%p"
REM @del /F /S /Q %systemdrive%\users\alumno\desktop\*.*
@del /F /S /Q %systemdrive%\users\alumno\desktop\ExamenED\*.*

@echo Borrando Descargas
@for /D %%p in (%systemdrive%\users\alumno\downloads\*.*)  do rd /S /Q "%%p"
@del /F /S /Q %systemdrive%\users\alumno\downloads\*.*

@echo Borrando Documents
@for /D %%p in (%systemdrive%\users\alumno\documents\*.*)  do rd /S /Q "%%p"
@del /F /S /Q %systemdrive%\users\alumno\documents\*.*

@echo Echo extrayendo ZIP al Escritorio
@7z x -o%systemdrive%\users\alumno\desktop\ ExamenED.zip

@start C:\eclipse\eclipse.exe -data %systemdrive%\users\alumno\desktop\ExamenED\workspace -showlocation
@echo Saliendo ...
@exit
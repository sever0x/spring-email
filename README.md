# Spring Email Sender & Forgot Password Examples

### Spring Email Sender Example
**What you need to do to make it work:**
1. Register or use an email account that has two-factor authentication
2. Configure SMPT to match the mail service you use (the project is configured to use Outlook)
3. Get the application password ([click to see how to do this on Outlook](https://support.microsoft.com/en-us/account-billing/using-app-passwords-with-apps-that-don-t-support-two-step-verification-5896ed9b-4263-e681-128a-a6f2979a7944 "click to see how to do this on Outlook"))

Pass in as environment variables
```
MAIL_USER=xxx@xxx.xxx; MAIL_PASSWORD=xxxxxxxxxxx
```

Send a POST request to this endpoint:
```
localhost:8080/send
```

The next JSON body (to - to whom you are sending the mail, subject - the subject of the mail, text - the mail itself):
```json
{
    "to": "xxx@xxx.xxx",
    "subject": "Something subject",
    "text": "Bla-bla-bla"
}
```
If you want to send an email with an attachment, try this:
```json
{
    "to": "xxx@xxx.xxx",
    "subject": "Something subject",
    "text": "Bla-bla-bla",
    "pathToAttachment": "D:/something.jpg"
}
```

### Forgot Password Example
**What you need to do to make it work:**
Using the settings you made before, you can now send POST requests to the following endpoints:
```
localhost:8080/forgot-password?email=xxx@xxx.xxx
```
At the request above you will send an email to the addressee about the password recovery

On the next POST request you can change the password, if such a token exists in the database and has not expired:
```
http://localhost:8080/recovery-password?token=somethingtoken
```
JSON body:
```json
{
    "password": "your new password"
}
```

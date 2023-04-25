# Spring Email Sender Example

**What you need to do to make it work:**
1. Register or use an email account that has two-factor authentication
2. Configure SMPT to match the mail service you use (the project is configured to use Outlook)
3. Get the application password (click to see how to do this on Outlook)

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

import json
import gspread
from google.oauth2.service_account import Credentials

scopes = [
    'https://www.googleapis.com/auth/spreadsheets',
    'https://www.googleapis.com/auth/drive'
]

credentials = Credentials.from_service_account_file(
    './credentials_.json',
    scopes=scopes
)

gc = gspread.authorize(credentials)

ss=gc.open('Microbe-scope')
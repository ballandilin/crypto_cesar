class Univers:
    def __init__(self):

        self._listeClesPubliques = {}
        self._listeMessagesPublics = {}
        self._instance = Univers()

    def get(self):
        return self._instance

    def adCles(id : str, )
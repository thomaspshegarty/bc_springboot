CREATE TABLE teams (
    id INTEGER,
    team VARCHAR(30),
    tag VARCHAR(3),
    region VARCHAR(3),
    wins INTEGER,
    losses INTEGER
);

CREATE TABLE players (
    id INTEGER,
    ign VARCHAR(30),
    team VARCHAR(30),
    tag VARCHAR(3),
    role VARCHAR(3)
);

/*INSERT INTO lcstracker.teams (id,team, tag, region, wins, losses)
VALUES
(
    1, "TEAM SOLO MID", "TSM", "NA",10,8
),
(
    2, "TEAM LIQUID", "TL", "NA",14,4
),
(
    3, "COUNTER LOGIC GAMING", "CLG",12,6
),
(
    4, "CLOUD 9", "C9", 12, 6
);

INSERT INTO lcstracker.players (id, ign, team, tag, role)
VALUES
(
    1, "BROKENBLADE","TEAM SOLO MID","TSM","TOP"
),
(
    2,"AKAADIAN","TEAM SOLO MID","TSM","JG"
),
(
    3,"DOUBLELIFT","TEAM LIQUID","TL","ADC"
),
(
    4,"COREJJ","TEAM LIQUID","TL","SUP"
)*/